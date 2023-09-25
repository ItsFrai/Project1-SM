
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
         if (this==obj) return true;
         Event event = (Event) obj;
             return Objects.equals(eventDate, event.eventDate) &&
                     Objects.equals(startTime, event.startTime) &&
                     Objects.equals(location, event.location);




}
     private String ToString(){
        return "[Event Date: " + date + "] [Start: " + startTime + "] [End: " + startTime+duration + "] @" + location + " [Contact: " + contact + "]";
     }

     private compareTo(){

     }
}



