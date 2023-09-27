
public class EventCalender {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public EventCalender() {
        events = new Event[4];
        numEvents = 0;
    }
    private int find(Event event) {
        for (int j = 0; j < numEvents; j++) {
            if (events[j].equals(event)) {
                return j;
            }
        }
        return -1;
    }
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
        System.out.println("start");
        int duplicateIndex = find(event);
        if (duplicateIndex != -1) {
            return false;
        }
        if (numEvents == events.length) {
            System.out.println("grow");
            grow();
        }
        events[numEvents] = event;
        numEvents++;
        System.out.println(numEvents);
        return true;
    }

    public boolean remove(Event event) {
        return false;
    }
    public boolean contains(Event event) {
        for (Event target : events) {
            if (target != null && event.compareTo(target) == 0) {
                return true;
            }
        }
        return false;
    }
    public void print() {
            for (int i = 0; i < numEvents; i++) {
                System.out.println(events[i].toString());
            }
        }
    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ }
}
