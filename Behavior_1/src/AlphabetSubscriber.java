import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Flow;

public class AlphabetSubscriber extends StringSubscriber {

    public AlphabetSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./AlphabetConsumer.txt");
        executor = ".*[a-zA-Z]+.*";
    }

}
