
public class Event implements Comparable<Event> {
    private Date date;

    private Timeslot startTime;
    private Location location;
    private Contact contact;
    private int duration;

    public Event(Date date, Timeslot timeslot, Location location, int duration, Contact contact) {
        this.date = date;
        this.startTime = timeslot;
        this.location = location;
        this.duration = duration;
        this.contact = contact;
    }


    @Override
    public int compareTo(Event o) {
        return 0;
    }
}



