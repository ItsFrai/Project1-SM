
public class EventCalender {
    private Event[] events; //the array holding the list of events
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
        } else {
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

    public void printByDate() {
        if (numEvents == 0) {
            System.out.println("Event calender is empty!");
        }
        for (int i = 0; i < numEvents - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < numEvents - i - 1; j++) {
                if (events[j].compareTo(events[j + 1]) > 0) {
                    // Swap events[j] and events[j+1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        // Now, events[] is sorted by date in-place
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
    }

    public void printByCampus() {
        if (numEvents == 0) {
            System.out.println("Event calender is empty!");
        }
        for (int i = 0; i < numEvents - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numEvents - i - 1; j++) {
                int locationCompare = events[j].getLocation().compareTo(events[j + 1].getLocation());

                if (locationCompare > 0) {
                    // Swap events[j] and events[j+1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // Now, events[] is sorted by location
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());

        }

    }

    public void printByDepartment() {
        if (numEvents == 0) {
            System.out.println("Event calender is empty!");
        }
        for (int i = 0; i < numEvents - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numEvents - i - 1; j++) {
                int departmentCompare = events[j].getDInitial().compareTo(events[j + 1].getDInitial());

                if (departmentCompare > 0) {
                    // Swap events[j] and events[j+1]
                    Event temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        // Now, events[] is sorted by department
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
    }
}
