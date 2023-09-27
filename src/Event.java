import java.util.Objects;

public class Event implements Comparable<Event> {
    private final Date date;
    private final Timeslot startTime;
    private final Location location;
    private final Contact contact;
    private final int duration;

    public Event(Date date, Timeslot timeslot, Location location, int duration, Contact contact) {
        this.date = date;
        this.startTime = timeslot;
        this.location = location;
        this.duration = duration;
        this.contact = contact;
    }

 @Override
    public boolean equals(Object obj) {
        Event event = (Event) obj;
        return this.date.equals(event.date) &&
                this.startTime.equals(event.startTime) &&
                this.location.equals(event.location);
    }



@Override
    public String toString(){
        return "[Event Date: " + date + "] [Start: " + startTime + "] [End: " + startTime+duration + "] @" + location + " [Contact: " + contact + "]";
     }
@Override
     public int compareTo(Event another){

        int datecomp= this.date.compareTo(another.date);

        if (datecomp==0){
            return this.startTime.compareTo(another.startTime);
        }
     return datecomp;

     }
}



