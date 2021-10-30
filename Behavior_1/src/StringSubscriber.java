import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public abstract class StringSubscriber implements Flow.Subscriber {

    private Flow.Subscription subscription;
    private String uid;
    protected Consumer consumer;

    public StringSubscriber(String uid) {
        this.uid = uid;
    }

    public void onSubscribe(Flow.Subscription subscription ) {
        this.subscription = subscription;
        System.out.println(this.uid + " Subscribed.");
        subscription.request(1);

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
        System.out.println("Done");
    }

}
