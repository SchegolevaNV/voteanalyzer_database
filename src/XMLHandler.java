import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class XMLHandler extends DefaultHandler {

    private Voter voter;
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private LinkedList<Voter> voterCounts;

    public XMLHandler() {
        voterCounts = new LinkedList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        try
        {
            if (qName.equals("voter"))
            {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            }
            else if (qName.equals("visit") && voter != null)
            {
                if (voterCounts.contains(voter))
                {
                    int count = voterCounts.get(voterCounts.indexOf(voter)).getCount();
                    voterCounts.get(voterCounts.indexOf(voter)).setCount(count + 1);
                }
                else
                {
                    voter.setCount(1);
                    voterCounts.add(voter);
                }
            }
        }
        catch (ParseException ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public void printDuplicatedVoters()
    {
        for (Voter voter : voterCounts) {
            int count = voter.getCount();
            if (count > 1) {
                System.out.println(voter.toString() +  " - " + count);
            }
        }
    }
}
