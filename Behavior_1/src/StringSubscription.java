import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private final StringSubscriber subscriber;

    private String cache;
    private long n;

    private boolean status;

    StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = (StringSubscriber) subscriber;
        this.status = true;
        this.cache = "";
    }

    public void updates(String item){
        if(!status) return;
        if(this.cache.length() +  item.length() >= n) {
            var data = (this.cache + item).substring(0, (int) this.n);
            if (subscriber.valid(data)) {
                subscriber.onNext(data);
                subscriber.onComplete();
                cancel();
            }
        }else {
            cache += item;
        }
    }

    public boolean containSub(Flow.Subscriber t) {
        return this.subscriber == t;
    }

    @Override
    public void request(long n) {
//        if(!status) return;

        if (n < 0) {
            subscriber.onError(new IllegalArgumentException());
        } else {
            status = true;
            this.n = n;
//            if use async method this field should start observer
        }
    }

    @Override
    public void cancel() {
        if(status) {
            status = false;
            System.out.println(subscriber.getUid() + " subscription has expired.");
        }
    }

}
