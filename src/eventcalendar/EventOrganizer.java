
package eventcalendar;


import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * EventOrganizer class manages event-related operations and interactions with the user.
 * Authors: Fraidoon Pourooshasb, Samman Pandey
 */
public class EventOrganizer {

    private final EventCalender eventCalender;// Initialize the EventCalendar instance

    /**
     * Constructor for EventOrganizer class.
     * Initializes the EventCalendar.
     */
    public EventOrganizer() {
        eventCalender = new EventCalender();

    }

    /**
     * Method to run the Event Organizer program.
     * Accepts user commands and processes them.
     */
    public void run() {
        System.out.println("eventcalendar.Event Organizer running...");

        Scanner scanner = new Scanner(System.in);

        String input;
        System.out.println();
        while (true) {
            input = scanner.nextLine();
            if (input.equals("Q")) {
                break;
            }
            processCommand(input);
        }
        scanner.close();

        System.out.println("eventcalendar.Event Organizer terminated");
    }

    /**
     * Process a command entered by the user.
     *
     * @param command The user's input command.
     */
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

                        if (duration < 30 || duration > 120) {
                            System.out.println("eventcalendar.Event duration must be at least 30 minutes and at most 120 minutes");
                            break;
                        }

                        Date date = Date.fromDateStr(dateString);

                        try {
                            Location locationstr = Location.valueOf(location.toUpperCase());
                            Timeslot timeslot = Timeslot.valueOf(timeSlot.toUpperCase());
                            Department departmentstr = Department.valueOf(department.toUpperCase());
                            Contact contact = new Contact(departmentstr, email);

                            // Check if the contact is valid
                            boolean isValidContact = contact.isValid();

                            if (!isValidContact) {
                                System.out.println("Invalid contact information!");
                            } else {
                                if (!date.isValid()) {
                                    System.out.println(dateString + ": Invalid calendar date!");
                                } else if (date.isFutureDate()) {
                                    System.out.println(dateString + ": eventcalendar.Event date must be a future date!");
                                } else if (date.isMoreThan6MonthsAway()) {
                                    System.out.println(dateString + ": eventcalendar.Event date must be within 6 months!");
                                } else {
                                    Event event = new Event(date, timeslot, locationstr, duration, contact);

                                    boolean added = eventCalender.add(event);

                                    boolean contains = eventCalender.contains(event);

                                    //fix contains method

                                    if (added) {
                                        System.out.println("eventcalendar.Event added to the calendar.");
                                    } else {
                                        System.out.println("The event is already on the calendar.");
                                    }
                                }
                            }
                        } catch (IllegalArgumentException e) {
                            if (e.getMessage().contains("eventcalendar.Timeslot")) {
                                System.out.println("Invalid time slot!");
                            } else if (e.getMessage().contains("eventcalendar.Location")) {
                                System.out.println("Invalid location!");
                            } else {
                                System.out.println("Invalid contact information!");
                            }
                        }
                    }
                    break;
                case "R":
                    if (tokenizer.countTokens() == 3) {
                        String dateString = tokenizer.nextToken();
                        String timeSlot = tokenizer.nextToken();
                        String location = tokenizer.nextToken();

                        Date date = Date.fromDateStr(dateString);

                        if (!date.isValid()) {
                            System.out.println(dateString + ": Invalid calendar date!");
                        } else if (date.isFutureDate()) {
                            System.out.println(dateString + ": eventcalendar.Event date must be a future date!");
                        } else if (date.isMoreThan6MonthsAway()) {
                            System.out.println(dateString + ": eventcalendar.Event date must be within 6 months!");
                        } else {
                            // Create an event to compare for removal
                            Event eventToRemove = new Event(date, Timeslot.valueOf(timeSlot.toUpperCase()),
                                    Location.valueOf(location.toUpperCase()),0,null);

                            // Check if the event is in the calendar
                            boolean removed = eventCalender.remove(eventToRemove);

                            if (removed) {
                                System.out.println("eventcalendar.Event has been removed from the calendar!");
                            } else {
                                System.out.println("Cannot remove; event is not in the calendar!");
                            }
                        }
                    }
                    break;
                case "P":
                    eventCalender.print();
                    break;
                case "PE":
                    // Implement the code to print events sorted by date and timeslot
                    eventCalender.printByDate();
                    break;
                case "PC":
                    // Implement the code to print events sorted by campus and building/room
                    eventCalender.printByCampus();
                    break;
                case "PD":
                    // Implement the code to print events sorted by department
                    eventCalender.printByDepartment();
                    break;
                default:
                    if (action.equals("a")) {
                        System.out.println();
                        System.out.println(action + " is an invalid command!");
                    } else {
                        System.out.println(action + " is an invalid command!");
                    }
            }
        }
    }
}
