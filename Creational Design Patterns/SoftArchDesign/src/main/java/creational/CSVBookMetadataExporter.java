package creational;

import java.io.IOException;
import java.io.PrintStream;

public class CSVBookMetadataExporter extends BookMetadataExporter{
    private CSVBookMetadataFormatter cvsB;

    @Override
    public void export(PrintStream stream) throws IOException {
        cvsB = new CSVBookMetadataFormatter();
        for (Book book : books){
            cvsB.append(book);
        }
        stream.println(cvsB.getMetadataString());
    }

}
