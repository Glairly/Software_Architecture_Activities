import java.io.FileWriter;
import java.io.IOException;

public class Consumer {
    private String filePath;

    private String buffer;

    public Consumer(String filePath) throws IOException {
        this.filePath = filePath;
        buffer = "";
    }

    public void consume(String value) throws IOException {
        buffer += value;
        FileWriter fw = new FileWriter(this.filePath);
        fw.write(value);
        fw.close();
    }

    public void changePath(String filePath) throws IOException {
        this.filePath = filePath;
    }

}
