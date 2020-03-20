import java.text.SimpleDateFormat;
import java.util.Date;

public class Voter
{
    private String name;
    private Date birthDay;
    private int count;


    public Voter(String name, Date birthDay)
    {
        this.name = name;
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object obj)
    {
        Voter voter = (Voter) obj;
        return name.equals(voter.name) && birthDay.equals(voter.birthDay);
    }

    @Override
    public int hashCode() {
        int code = name.hashCode() + birthDay.hashCode();
        return code;
    }

    public String toString()
    {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy.MM.dd");
        return name + " (" + dayFormat.format(birthDay) + ")";
    }

    public String getName()
    {
        return name;
    }

    public Date getBirthDay()
    {
        return birthDay;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount()
    {
        return count;
    }
}
