
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

        return "[Event Date: " + date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + "] " +
                "[Start: " + startHour + ":" + formattedStartMin + xIndicator + "] " +
                "[End: " + endHour + ":" + formattedEndMin + nIndicator + "] " + location + " " +
                "[Contact: " + contact.getDepartment() + ", " + contact.getEmail() + "]";
    }

    @Override
//boolean printByDate, boolean printByCampus
    public int compareTo(Event another) {
//if (printByDate){
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
        return 0;}



    public Department getDInitial(){
        return contact.getDepartment();

    }

    public String getCampus() {
        return location.getCampus();
    }

    public String getBuilding() {
        return location.getBuilding();
    }

    public static void main(String[] args) {
        testEventEqualitybyTime();
        testEventEqualitybyDate();
        testEventEqualitybyLocation();
    }

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

        System.out.println("**Test case #2: Check to see if events are equal by Date");
        testingresults(expected,actual);
    }
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

        System.out.println("**Test case #3: Check to see if events are equal by Location");
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

}


