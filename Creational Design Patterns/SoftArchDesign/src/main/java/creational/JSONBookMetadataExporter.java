package creational;

import java.io.PrintStream;

public class JSONBookMetadataExporter extends BookMetadataExporter{
    private JSONBookMetadataFormatter jsonB;
    @Override
    public void export(PrintStream stream) {
        jsonB = new JSONBookMetadataFormatter();
        for (Book book : books){
            jsonB.append(book);
        }
        stream.println(jsonB.getMetadataString());
    }
}
