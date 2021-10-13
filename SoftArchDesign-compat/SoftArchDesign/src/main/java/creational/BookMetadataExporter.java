package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintStream;

public abstract class BookMetadataExporter extends BookCollection {

    BookMetadataFormatter formatter;

    public void export(PrintStream stream) throws ParserConfigurationException, IOException {
        // Please implement this method. You may create additional methods as you see fit.
        for(var book : books){
            formatter.append(book);
        }
        stream.print(formatter.getMetadataString());
    }


}
