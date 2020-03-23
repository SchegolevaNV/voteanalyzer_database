import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.SQLException;
import java.util.LinkedList;

public class XMLHandler extends DefaultHandler {

    private int itterator = 0;
//    private Voter voter;
//    private LinkedList<Voter> voterCounts;

//    public XMLHandler() {
//        voterCounts = new LinkedList<>();
//    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("voter")) {
            String birthDay = attributes.getValue("birthDay").replace('.', '-');
            String name = attributes.getValue("name");
            DBConnection.countVoter(name, birthDay);
            itterator++;
        }
    }

    private static Thread threadCreation(StringBuffer stringBuffer) {

        return new Thread(() -> {

        });
    }

            public void writeToDb() throws SQLException {
        int itterator = 0;
        for (int i = 0; i < voterCounts.size(); i++)
        {
            DBConnection.countVoter(voterCounts.get(i).getName(), voterCounts.get(i).getBirthDay());
            itterator++;

            if (itterator == 1_000_000) {
                DBConnection.executeMultiInsert();
                DBConnection.getInsertQuery().delete(0, DBConnection.getInsertQuery().length());
                itterator = 0;
            }
        }
    }
}
           // DBConnection.countVoter(name, birthDay);
            //itterator++;

//            if (itterator == 1_000_000) {
//                try {
//                    DBConnection.executeMultiInsert();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                DBConnection.getInsertQuery().delete(0, DBConnection.getInsertQuery().length());
//                itterator = 0;
//            }
    //    }
//            voter = new Voter(name, birthDay);
//            voterCounts.add(voter);
//        }
//        else if (qName.equals("visit") && voter != null)
//        {
//            if (voterCounts.contains(voter))
//            {
//                int count = voterCounts.get(voterCounts.indexOf(voter)).getCount();
//                voterCounts.get(voterCounts.indexOf(voter)).setCount(count + 1);
//            }
//            else {
//                voter.setCount(1);
//                voterCounts.add(voter);
//            }
//        }
  //  }

//    @Override
//    public void endElement(String uri, String localName, String qName) {
//        if (qName.equals("voter")) {
//            voter = null;
//        }
//    }
//}