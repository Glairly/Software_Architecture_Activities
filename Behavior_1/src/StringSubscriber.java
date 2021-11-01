import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public abstract class StringSubscriber implements Flow.Subscriber {

    private Flow.Subscription subscription;

    public String getUid() {
        return uid;
    }

    private String uid;
    protected Consumer consumer;
    protected String executor;

    public StringSubscriber(String uid) {
        this.uid = uid;
    }

    public void renew(long n){
        subscription.request(n);
    }

    public boolean valid(Object item){
        return Pattern.matches(this.executor,(String) item);
    }

    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        System.out.println(this.uid + " Subscribed.");
        subscription.request(10);

    }

    public void onNext(Object item) {
        System.out.println(this.uid + " Got : " + item);
        try {
            consumer.consume((String) item);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onError(Throwable ex) { ex.printStackTrace(); }
    public void onComplete() {
        System.out.println(this.uid + " received a message.");
    }

}
