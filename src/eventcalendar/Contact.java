
package eventcalendar;

/**
 * Represents a contact with a department and email information.
 * This class stores information about a contact's department and email address.
 * It also provides methods to access and validate the contact's information.
 *
 * @author Fraidoon Pourooshasb, Samman Pandey
 */
public class Contact {
    private final Department department; // The department associated with the contact.
    private final String email; // The email address of the contact.

    /**
     * Constructs a new Contact object with the specified department and email.
     *
     * @param department The department of the contact.
     * @param email      The email address of the contact.
     */
    public Contact(Department department, String email) {
        this.department = department;
        this.email = email;
    }

    /**
     * Retrieves the department associated with this contact.
     *
     * @return The department of the contact.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Retrieves the email address of this contact.
     *
     * @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Checks if the contact is valid based on certain criteria.
     * A contact is considered valid if the department is not null
     * and the email address ends with "@rutgers.edu".
     *
     * @return True if the contact is valid, false otherwise.
     */
    public boolean isValid() {
        return this.department != null && this.email.endsWith("@rutgers.edu");
    }
}

