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
                        Location locationstr = Location.valueOf(location);
                        Department departmentstr = Department.valueOf(department);
                        Contact contact = new Contact(departmentstr, email);
                        
                        
                        Event event = new Event(date, timeslot, locationstr, duration, contact);


                    }
                    break;
                case "R":
                    if (tokenizer.countTokens() == 3) {
                        String dateString = tokenizer.nextToken();
                        String timeSlot = tokenizer.nextToken();
                        String location = tokenizer.nextToken();

                        // Now you have the tokens for the "R" command
                    }
                    break;
                // Handle other commands as needed
                default:
                    throw new IllegalStateException("Unexpected value: " + action);
            }
        }
    }
}
