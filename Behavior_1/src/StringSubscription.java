import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private final Flow.Subscriber subscriber;

    private boolean status;

    StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
        this.status = true;
    }

    public void updates(Object item){
        if(subscriber != null && status)
            subscriber.onNext(item);
    }

    public boolean containSub(Flow.Subscriber t) {
        return this.subscriber == t;
    }

    @Override
    public void request(long n) {
        if(!status) return;

        if (n < 0) {
            subscriber.onError(new IllegalArgumentException());
        } else {
//            if use async method this field should start observer
        }
    }

    @Override
    public void cancel() {
        status = false;
    }


}
