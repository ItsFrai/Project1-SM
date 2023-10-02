package eventcalendar;

/**
 * A class that represents an event calendar for managing events.
 *
 * @author Fraidoon Pourooshasb
 * @author Samman Pandey
 */
public class EventCalender {
    private Event[] events; //the array holding the list of events
    private int numEvents; //current number of events in the array

    /**
     * Constructs an empty event calendar with an initial capacity of 4.
     */
    public EventCalender() {
        events = new Event[4];
        numEvents = 0;
    }

    /**
     * Finds the index of an event in the events array.
     *
     * @param event The event to search for.
     * @return The index of the event if found, or -1 if not found.
     */
    private int find(Event event) {
        for (int i = 0; i < numEvents; i++) {
            if (events[i].equals(event)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Increases the capacity of the events array by 4.
     */
    private void grow() {

        Event[] newEvents = new Event[events.length + 4];

        // Copy elements from the old array to the new one
        for (int i = 0; i < events.length; i++) {
            newEvents[i] = events[i];
        }
        // Update the reference to the events array
        events = newEvents;
    }

    /**
     * Adds an event to the event calendar if it's not a duplicate.
     *
     * @param event The event to add.
     * @return True if the event was added, false if it's a duplicate or the array is full.
     */
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

/**
 * Removes an event from the event calendar.
 *
 * @param event The event to remove.
 */
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

    /**
     * Checks if the event calendar contains a specific event.
     *
     * @param event The event to check for.
     * @return True if the event is found in the calendar, false otherwise.
     */
    public boolean contains(Event event) {
        for (Event target : events) {
            if (target != null && event.compareTo(target) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all events in the event calendar.
     */
    public void print() {
        if (numEvents == 0) {
            System.out.println("eventcalendar.Event calendar is empty!");
        } else {
            System.out.println("* eventcalendar.Event calendar * ");
            for (int i = 0; i < numEvents; i++) {
                System.out.println(events[i].toString());
            }
            System.out.println("* end of event calendar *");
        }
    }

    /**
     * Prints events in the event calendar sorted by date and time.
     */
    public void printByDate() {
        if (numEvents == 0) {
            System.out.println("eventcalendar.Event calender is empty!");
            return;
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
        System.out.println("* eventcalendar.Event calendar by event date and start time * ");
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
        System.out.println("* end of event calendar *");


    }

    /**
     * Prints events in the event calendar sorted by campus and building.
     */
    public void printByCampus() {
        if (numEvents == 0) {
            System.out.println("eventcalendar.Event calender is empty!");
            return;
        }
        for (int i = 0; i < numEvents - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numEvents - i - 1; j++) {
                int campusCompare = events[j].getCampus().compareTo(events[j+1].getCampus());
                int buildingCompare = events[j].getBuilding().compareTo(events[j+1].getBuilding());


                if (campusCompare > 0 || (campusCompare == 0 && buildingCompare > 0)) {
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

        System.out.println("* eventcalendar.Event calendar by campus and building *");
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
        System.out.println("* end of event calendar *");

    }

    /**
     * Prints events in the event calendar sorted by department.
     */
    public void printByDepartment() {
        if (numEvents == 0) {
            System.out.println("eventcalendar.Event calender is empty!");
            return;
        }
        for (int i = 0; i < numEvents - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < numEvents - i - 1; j++) {
                int departmentCompare = events[j].getDepartmentInitial().getDepartmentInitial().compareTo(events[j + 1].getDepartmentInitial().getDepartmentInitial());

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

        System.out.println("* eventcalendar.Event calendar by department * ");
        for (int i = 0; i < numEvents; i++) {
            System.out.println(events[i].toString());
        }
        System.out.println("* end of event calendar * ");
    }
}
