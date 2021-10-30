import java.io.IOException;
import java.util.concurrent.Flow;

public class NumberSubscriber extends StringSubscriber {

    public NumberSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./NumbersConsumer.txt");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(Object item) {
        try {
            boolean valid = ((String) item).matches(".*[0-9]+.*");
            if(valid)
                super.onNext(item);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
