import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class LoaderXML {

    public static void main(String[] args) throws Exception
    {
        //SAX-PARSER

        long usage2 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        String fileName = "res/data-18M.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(new File(fileName), handler);
        handler.printDuplicatedVoters();

        long us2Finish = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("\nusage = " + formatSize(us2Finish - usage2));
    }

    private static String formatSize(long v)
    {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double) v / (1L << (z * 10)), " KMGTPE".charAt(z));
    }
}
