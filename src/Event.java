
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
        return startTime.equals(event.startTime) &&
                date.getYear() == event.date.getYear() &&
                date.getMonth() == event.date.getMonth() &&
                date.getDay() == event.date.getDay() &&
                location.equals(event.location);
    }

    @Override
    public String toString() {
        int startHour = startTime.getHour();
        int startMin = startTime.getMinute();
        String nIndicator = startTime.getIndicator();

        int endMin = startMin + duration;
        int endHour = startHour;

        if (endMin >= 60) {
            endHour += endMin / 60;
            endMin = (endMin % 60);
        }

        String formattedStartMin = String.format("%02d", startMin);
        String formattedEndMin = String.format("%02d", endMin);

        return "[Event Date: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + "] " +
                "[Start: " + startHour + ":" + formattedStartMin + nIndicator + "] " +
                "[End: " + endHour + ":" + formattedEndMin + nIndicator + "] " + location + " " +
                "[Contact: " + contact.getDepartment() + ", " + contact.getEmail() + "]";
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



