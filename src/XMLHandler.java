import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.SQLException;

public class XMLHandler extends DefaultHandler {

    private int itterator = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equals("voter")) {
            String birthDay = attributes.getValue("birthDay").replace('.', '-');
            String name = attributes.getValue("name");
            DBConnection.countVoter(name, birthDay);
            itterator++;

            if (itterator == 1_000_000)
            {
                try {
                    DBConnection.executeMultiInsert();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.getInsertQuery().delete(0, DBConnection.getInsertQuery().length());
                itterator = 0;
            }
        }
    }
}