
public class EventCalender {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public EventCalender() {
        events = new Event[4];
        numEvents = 0;
    }
    private int find(Event event) {
        return 0;
    } //search an event in the list
    private void grow() {

        Event[] newEvents = new Event[events.length + 4];

        // Copy elements from the old array to the new one
        for (int i = 0; i < events.length; i++) {
            newEvents[i] = events[i];
        }
        // Update the reference to the events array
        events = newEvents;
    }
    public boolean add(Event event) {
        if (events.length == numEvents) {
            grow();
        } else {
            events[numEvents] = event;
            numEvents++;
            return true;
        }
        return false;
    }
    public boolean remove(Event event) {

    }
    public boolean contains(Event event) {
        for (Event target: events) {
            if (event.compareTo(target) == 0) {
                return true;
            }
        }
        return false;
    }
    public void print() { } //print the array as is
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ }
}
