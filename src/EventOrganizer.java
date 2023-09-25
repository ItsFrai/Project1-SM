import java.util.Scanner;
import java.util.StringTokenizer;

public class EventOrganizer {

    public void run() {
        System.out.println("Event Organizer running...");

        Scanner scanner = new Scanner(System.in);



        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            processCommand(input);
        }
        scanner.close();

        System.out.println("Event Organizer terminated");
    }

    private void processCommand(String command) {
        StringTokenizer tokenizer = new StringTokenizer(command);
        if (tokenizer.hasMoreTokens()) {
            String action = tokenizer.nextToken();

            switch (action) {
                case "A":
                    if (tokenizer.countTokens() == 6) {
                        String dateString = tokenizer.nextToken();
                        String timeSlot = tokenizer.nextToken();
                        String location = tokenizer.nextToken();
                        String department = tokenizer.nextToken();
                        String email = tokenizer.nextToken();
                        int duration = Integer.parseInt(tokenizer.nextToken());

                        Date date = Date.fromDateStr(dateString);
                        Timeslot timeslot = Timeslot.valueOf(timeSlot);
                        Location locationstr = Location.valueOf(location.toUpperCase());

                        try {
                            Department departmentstr = Department.valueOf(department.toUpperCase());
                            Contact contact = new Contact(departmentstr, email);

                            // Check if the contact is valid
                            boolean isValidContact = contact.isValid();

                            if (!isValidContact) {
                                System.out.println("Invalid contact information!");
                            } else {
                                Event event = new Event(date, timeslot, locationstr, duration, contact);

                                EventCalender eventCalender = new EventCalender();

                                boolean added = eventCalender.add(event);
                                boolean contains = eventCalender.contains(event);

                                //fix contains method

                                if (added) {
                                    System.out.println("Event added");
                                }

                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid contact information!");
                        }
                    }
                    break;
                case "R":
                    if (tokenizer.countTokens() == 3) {
                        String dateString = tokenizer.nextToken();
                        String timeSlot = tokenizer.nextToken();
                        String location = tokenizer.nextToken();


                        EventCalender eventCalender = new EventCalender();



                    }
                    break;
                // Handle other commands as needed
                default:

                    System.out.println("\n" + action + " is not a valid command");
            }
        }
    }
}
