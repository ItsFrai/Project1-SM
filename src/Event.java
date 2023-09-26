import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        Event event = (Event) obj;
        return date.equals(event.date) &&
                startTime.equals(event.startTime) &&
                location.equals(event.location);
    }



@Override
    public String toString(){

        return "[Event Date: " + date + "] [Start: " + startTime + "] [End: " + startTime+duration + "] @" + location + " [Contact: " + contact + "]";
     }

@Override
     public int compareTo(Event another){

        int datecomp= this.date.compareTo(another.date);

        if (datecomp==0){
            int StartTimecomp= this.startTime.compareTo(another.startTime);
            if (StartTimecomp==0){
                return 0;
            }
        return StartTimecomp;
        }
     return datecomp;

     }
}



