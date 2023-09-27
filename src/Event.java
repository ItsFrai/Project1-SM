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
        return startTime.equals(event.startTime) &&
                date.getYear() == event.date.getYear() &&
                date.getMonth() == event.date.getMonth() &&
                date.getDay() == event.date.getDay() &&
                location.equals(event.location);
    }

@Override
    public String toString(){
        int StartHour= startTime.getHour();
        int StartMin= startTime.getMinute();
        String NIndicator=startTime.getIndicator();

        int EndMin= StartMin+duration;
        int EndHour=StartHour;
        if (EndMin>=60){
            EndHour= EndHour+(EndMin/60);
            EndMin =StartMin+(EndMin%60);
            if (EndMin<10){
                //Something to make the min 0?
            }
        }
        if (StartHour==10 && duration>=90){
            NIndicator="pm";
        }
        return "[Event Date: " + date.getMonth()+"/" +date.getDay()+ "/" +date.getYear()+"] " +
                "[Start:" + StartHour +": "+StartMin +startTime.getIndicator()+  "] " +
                "[End:" + EndHour + ": "+ EndMin + NIndicator + "] @" + location + " " +
                "[Contact: " + contact.getDepartment()+","+contact.getEmail() + "]";
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



