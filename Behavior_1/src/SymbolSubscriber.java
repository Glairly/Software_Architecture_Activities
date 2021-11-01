import java.io.IOException;
import java.util.concurrent.Flow;

public class SymbolSubscriber extends StringSubscriber {

    public SymbolSubscriber(String uid) throws IOException {
        super(uid);
        consumer = new Consumer("./SymbolsConsumer.txt");
        executor = ".*[-+*/%@()]*"; // just an example of symbol filtering
    }
}
