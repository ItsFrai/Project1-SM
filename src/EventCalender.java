
public class EventCalender {
    private Event [] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    public EventCalender() {
        events = new Event[4];
        numEvents = 0;
    }
    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
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
        int duplicateIndex = find(event);
        if (duplicateIndex != -1) {
            return false;
        }
        if (numEvents == events.length) {
            grow();
        }
        events[numEvents] = event;
        numEvents++;
        return true;
    }

    public boolean remove(Event event) {
        int found = find(event);
        if (found == -1) {
            return false;
    }   else {
            for (int i = found; i < numEvents - 1; i++) {
                events[i] = events[i + 1];
            }
            events[numEvents - 1] = null;
            numEvents--;
            return true;
        }
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
        if (numEvents == 0) {
            System.out.println("Event calendar is empty!");
        } else {
            for (int i = 0; i < numEvents; i++) {
                System.out.println(events[i].toString());
            }
        }
    }

    public void printByDate() { } //ordered by date and timeslot
    public void printByCampus() { } //ordered by campus and building/room
    public void printByDepartment(){ }
}
