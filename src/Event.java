
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
    public static void main(String[] args) {
        testEventEquality();
        testEventToString();
        testEventComparison();
    }

    private static void testEventEquality() {
        Date date1 = new Date(2023, 9, 29);
        Timeslot timeslot1 = Timeslot.MORNING;
        Location location1 = Location.AB2225;
        Contact contact1 = new Contact(Department.CS, "cs@rutgers.edu");
        int duration1 = 60;

        Event event1 = new Event(date1, timeslot1, location1, duration1, contact1);
        Event event2 = new Event(date1, timeslot1, location1, duration1, contact1);

        boolean expected = true;
        boolean actual = event1.equals(event2);

        System.out.println("**Test case #1: Check to see if events are equal");
        testingresults(expected,actual);
    }

    private static void testEventToString() {
        Date date = new Date(2023, 9, 30);
        Timeslot timeslot = Timeslot.MORNING;
        Location location = Location.AB2225;
        Contact contact = new Contact(Department.CS, "cs@rutgers.edu");
        int duration = 45;

        Event event = new Event(date, timeslot, location, duration, contact);

        String expected = "[Event Date: 9/30/2023] [Start: 10:30am] [End: 11:15am] @AB2225 (Academic Building, College Avenue) [Contact: Computer Science, cs@rutgers.edu]";
        String actual = event.toString();

        System.out.println("**Test case #2: Checking toString Method when processing Event");
        testingresultsbystring(expected,actual);
    }

    private static void testEventComparison() {
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
        int comparison = event1.compareTo(event2);
        boolean actual = comparison == 0;


        System.out.println("**Test case #3: Event Comparison using the compareto method");
        testingresults(expected,actual);
    }

    private static void testingresults(boolean expected, boolean actual) {
        System.out.println("Expected Output: " + expected);
        System.out.println("Actual Output: " + actual);

        if (expected == actual) {
            System.out.println("Test Result: Passed\n");
        } else {
            System.out.println("Test Result: Failed\n");
        }
    }
    private static void testingresultsbystring(String expected, String actual) {
        System.out.println("Expected Output: " + expected);
        System.out.println("Actual Output: " + actual);

        if (expected.equals(actual)) {
            System.out.println("Test Result: Passed\n");
        } else {
            System.out.println("Test Result: Failed\n");
        }
    }
}



