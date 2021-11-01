import java.io.IOException;
import java.util.concurrent.Flow;
import java.util.regex.Pattern;

public class NumberSubscriber extends StringSubscriber {

    public NumberSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./NumbersConsumer.txt");
        executor = ".*[0-9]+.*";
    }
}
