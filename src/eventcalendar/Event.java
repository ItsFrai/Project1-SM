package eventcalendar;

/**
 * Represents an event with date, time, location, contact, and duration information.
 * This class defines an event with various attributes and provides methods for comparing events,
 * checking equality, and retrieving specific event details.
 * @author Fraidoon Pourooshasb, Samman Pandey
 */
public class Event implements Comparable<Event> {
    private final Date date;// The date of the event
    private final Timeslot startTime;// The start time of the event
    private final Location location;// The location of the event
    private final Contact contact;// The contact associated with the event
    private final int duration;// The duration of the event in minutes


    /**
     * Constructs an Event object with the specified date, timeslot, location, duration, and contact.
     *
     * @param date     The date of the event.
     * @param timeslot The start time of the event.
     * @param location The location of the event.
     * @param duration The duration of the event in minutes.
     * @param contact  The contact associated with the event.
     */
    public Event(Date date, Timeslot timeslot, Location location, int duration, Contact contact) {
        this.date = date;
        this.startTime = timeslot;
        this.location = location;
        this.duration = duration;
        this.contact = contact;
    }

    /**
     * Checks if this event is equal to another event based on their start time, date, and location.
     *
     * @param obj The object to compare to this event.
     * @return True if the events are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        Event event = (Event) obj;
        return startTime.equals(event.startTime) &&
                date.getYear() == event.date.getYear() &&
                date.getMonth() == event.date.getMonth() &&
                date.getDay() == event.date.getDay() &&
                location.equals(event.location);
    }

    /**
     * Returns a string representation of this event,
     * including its date, time, location, and contact details.
     *
     * @return A formatted string representing the event.
     */
    @Override
    public String toString() {
        int startHour = startTime.getHour();
        int startMin = startTime.getMinute();
        String xIndicator = startTime.getIndicator();

        int endMin = startMin + duration;
        int endHour = startHour;

        if (endMin >= 60) {
            endHour += endMin / 60;
            endMin = (endMin % 60);
        }
        String nIndicator = startTime.getIndicator();
        if (startHour < 12 && endHour >= 12) {
            nIndicator = "pm";
        }

        String formattedStartMin = String.format("%02d", startMin);
        String formattedEndMin = String.format("%02d", endMin);

        return "[eventcalendar.Event eventcalendar.Date: " + date.getMonth() + "/"
                + date.getDay() + "/" + date.getYear() + "] " + "[Start: " + startHour + ":"
                + formattedStartMin + xIndicator + "] " + "[End: " + endHour + ":" + formattedEndMin
                + nIndicator + "] " + location + " " + "[eventcalendar.Contact: "
                + contact.getDepartment() + ", " + contact.getEmail() + "]";
    }

    /**
     * Compares this event to another event for sorting purposes based on their date and start time.
     *
     * @param another The event to compare to this event.
     * @return 0 if both events are equal, a positive value if this event is greater,
     * and a negative value if this event is lesser.
     */
    @Override
    public int compareTo(Event another) {
        int datecomp = this.date.compareTo(another.date);

        if (datecomp > 0) {
            return 1;
        }
        if (datecomp < 0) {
            return -1;
        }

        int timeCompare = this.startTime.compareTo(another.startTime);
        if (timeCompare > 0) {
            return 1;
        }
        if (timeCompare < 0) {
            return -1;
        }
        return 0;
    }


    /** @return The department initial of the contact.
     */
    public Department getDepartmentInitial(){
        return contact.getDepartment();

    }

    /** @return The campus of the event's location.
     */
    public String getCampus() {
        return location.getCampus();
    }

    /** @return The building of the event's location.
     */
    public String getBuilding() {
        return location.getBuilding();
    }

    /** Where the test runs */
    public static void main(String[] args) {
        testEventEqualitybyTime();
        testEventEqualitybyDate();
        testEventEqualitybyLocation();
    }

    /** Test case 1 */
    private static void testEventEqualitybyTime() {
        Date date1 = new Date(2023, 9, 29);
        Timeslot timeslot1 = Timeslot.MORNING;
        Location location1 = Location.AB2225;
        Contact contact1 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration1 = 60;

        Event event1 = new Event(date1, timeslot1, location1, duration1, contact1);

        Date date2 = new Date(2023, 9, 29);
        Timeslot timeslot2 = Timeslot.AFTERNOON;
        Location location2 = Location.AB2225;
        Contact contact2 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration2 = 60;
        Event event2 = new Event(date2, timeslot2, location2, duration2, contact2);

        boolean expected = false;
        boolean actual = event1.equals(event2);

        System.out.println("**Test case #1: Check to see if events are equal by Time");
        testingresults(expected,actual);
    }

    /** Test case 2 */
    private static void testEventEqualitybyDate() {
        Date date1 = new Date(2023, 9, 29);
        Timeslot timeslot1 = Timeslot.MORNING;
        Location location1 = Location.AB2225;
        Contact contact1 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration1 = 60;

        Event event1 = new Event(date1, timeslot1, location1, duration1, contact1);

        Date date2 = new Date(2024, 9, 29);
        Timeslot timeslot2 = Timeslot.MORNING;
        Location location2 = Location.AB2225;
        Contact contact2 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration2 = 60;
        Event event2 = new Event(date2, timeslot2, location2, duration2, contact2);

        boolean expected = false;
        boolean actual = event1.equals(event2);

        System.out.println("**Test case #2: Check to see if events are equal by eventcalendar.Date");
        testingresults(expected,actual);
    }

    /** Test case 3 */
    private static void testEventEqualitybyLocation() {
        Date date1 = new Date(2023, 9, 29);
        Timeslot timeslot1 = Timeslot.MORNING;
        Location location1 = Location.AB2225;
        Contact contact1 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration1 = 60;

        Event event1 = new Event(date1, timeslot1, location1, duration1, contact1);

        Date date2 = new Date(2023, 9, 29);
        Timeslot timeslot2 = Timeslot.MORNING;
        Location location2 = Location.MU302;
        Contact contact2 = new Contact(Department.CS, "hr@rutgers.edu");
        int duration2 = 60;
        Event event2 = new Event(date2, timeslot2, location2, duration2, contact2);

        boolean expected = false;
        boolean actual = event1.equals(event2);

        System.out.println("**Test case #3: Check to see if events are equal by eventcalendar.Location");
        testingresults(expected,actual);
    }

    /**
     * Prints the expected and actual output of a test case, and indicates whether the
     * test passed or failed.
     *
     * @param expected The expected output of the test case.
     * @param actual   The actual output of the test case.
     */
    private static void testingresults(boolean expected, boolean actual) {
        System.out.println("Expected Output: " + expected);
        System.out.println("Actual Output: " + actual);

        if (expected == actual) {
            System.out.println("Test Result: Passed\n");
        } else {
            System.out.println("Test Result: Failed\n");
        }
    }

}


