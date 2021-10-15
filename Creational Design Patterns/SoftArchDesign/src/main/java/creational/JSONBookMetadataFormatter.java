package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.StringWriter;
import java.util.Arrays;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {
    private StringWriter writer;
    private JSONArray jsonList;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        jsonList = new JSONArray();
        writer = new StringWriter();
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject jsonObject = new JSONObject();
        JSONArray data = new JSONArray();
        data.addAll(Arrays.asList(b.getAuthors()));
        jsonObject.put(Book.Metadata.ISBN.value,b.getISBN());
        jsonObject.put(Book.Metadata.AUTHORS.value,data);
        jsonObject.put(Book.Metadata.TITLE.value,b.getTitle());
        jsonObject.put(Book.Metadata.PUBLISHER.value,b.getPublisher());
        jsonList.add(jsonObject);
        return this;
    }

    @Override
    public String getMetadataString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Book.class.getSimpleName()+"s",jsonList);
        writer.write(jsonObject.toJSONString());
        return writer.toString();
    }
}
