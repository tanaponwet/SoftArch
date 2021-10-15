package creational;

import javax.xml.parsers.ParserConfigurationException;
import java.io.PrintStream;

public class XMLBookMetaDataExporter extends BookMetadataExporter{
    private XMLBookMetadataFormatter xmlB;

    @Override
    public void export(PrintStream stream) throws ParserConfigurationException {
        xmlB = new XMLBookMetadataFormatter();
        for (Book book : books){
            xmlB.append(book);
        }
        stream.println(xmlB.getMetadataString());
    }
}
