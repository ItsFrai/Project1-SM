public class EventCalender {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public EventCalender() {
        events = new Event[4];
        numEvents = 0;
    }
    private int find(Event event) { } //search an event in the list
    private void grow() { } //increase the capacity by 4
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

    public boolean remove(Event event) { }
    public boolean contains(Event event) { }
    public void print() { } //print the array as is
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ }
}
