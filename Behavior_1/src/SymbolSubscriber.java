import java.io.IOException;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {

    public SymbolSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./SymbolsConsumer.txt");
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        super.onSubscribe(subscription);
    }

    @Override
    public void onNext(Object item) {
        try {
            String valid = ((String) item).replaceAll("[a-zA-Z0-9 ]","");
            if(!valid.equals(""))
                super.onNext(item);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
