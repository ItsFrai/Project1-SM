
package eventcalendar;

/**
 * Enum representing academic departments.
 * This enum defines departments along with their full names
 * and provides methods to retrieve department information.
 * @Fraidoon Pourooshasb
 * @Samman Pandey
 */

public enum Department {
    CS("Computer Science"), EE("Electrical Engineering"),
    ITI("Information Technology and Informatics"),
    MATH("Mathematics"), BAIT("Business Analytics and Information Technology");


    private final String fullName;


    /**
     * Constructs a Department enum value with its full name.
     *
     * @param fullName The full name of the department.
     */
    Department(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Retrieves the full name of the department.
     *
     * @return The full name of the department.
     */
    @Override
    public String toString() {
        return fullName;
    }


    /**
     * Retrieves the initial letter of the department's full name.
     *
     * @return The initial letter of the department's full name.
     */
    public String getDepartmentInitial() {
        return fullName.substring(0, 1);
    }
}



