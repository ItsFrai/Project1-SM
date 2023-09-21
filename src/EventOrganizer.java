import java.util.Scanner;

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
        String [] tokens = command.split(" ");
        String action = tokens[0];

        switch (action) {
            case ("A"):
                if (tokens.length == 7) {
                    String dateString = tokens[1];
                    String timeSlot = tokens[2];
                    String Location = tokens[3];
                    String department = tokens[4];
                    String email = tokens[5];
                    int duration = Integer.parseInt(tokens[6]);

            }
            case ("R"):
                if (tokens.length == 4) {
                    String dateString = tokens[1];
                    String timeSlot = tokens[2];
                    String Location = tokens[3];
                }
        }
    }
}
