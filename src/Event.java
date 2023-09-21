import java.util.Date;

public class Event implements Comparable<Event> {
    private Date date;
    private Timeslot timeslot;
    private Location location;
    private Contact contact;
    private int duration;

    @Override
    public int compareTo(Event o) {
        return 0;
    }
}



