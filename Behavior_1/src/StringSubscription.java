import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription {

    private Flow.Subscriber subscriber;

    private boolean status;

    StringSubscription(Flow.Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    @Override
    public void request(long n) {
        if (n < 0) {
            subscriber.onError(new IllegalArgumentException());
        } else {
            status = true;
        }
    }

    @Override
    public void cancel() {
        status = false;
    }
}
