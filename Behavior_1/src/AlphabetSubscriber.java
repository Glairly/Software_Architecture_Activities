import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./AlphabetConsumer.txt");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(Object item) {
        try {
            boolean valid = ((String) item).matches(".*[a-zA-Z]+.*");
            if(valid)
                super.onNext(item);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
