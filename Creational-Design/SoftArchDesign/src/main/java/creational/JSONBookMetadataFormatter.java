package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONObject obj;
    private JSONArray  books;

    public JSONBookMetadataFormatter() throws IOException {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        // Please implement this method. You may create additional methods as you see fit.
        obj = new JSONObject();
        books = new JSONArray();
        obj.put("Books",books);
        return null;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        // Please implement this method. You may create additional methods as you see fit.
        var o = new JSONObject();
        o.put("ISBN",b.getISBN());
        o.put("Title",b.getTitle());
        o.put("Publisher",b.getPublisher());

        var oL = new JSONArray();
        for(var auth : b.getAuthors()){
            oL.add(auth);
        }
        o.put("Authors",oL);
        books.add(o);
        return this;
    }

    @Override
    public String getMetadataString() {
        // Please implement this method. You may create additional methods as you see fit.
        return obj.toString();
    }
}
