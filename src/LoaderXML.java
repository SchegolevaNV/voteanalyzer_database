import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LoaderXML {

    public static void main(String[] args) throws Exception
    {
        String fileName = "res/data-1572M.xml";
        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);

        DBConnection.executeMultiInsert();

        System.out.println("Parsing time is: " + ((System.currentTimeMillis() - start) / 1000 / 60) + " мин.");

        DBConnection.printVoterCounts();
    }
}
