package eventcalendar;
/**
 *  represents different event locations, with each location having a full name
 * @Fraidoon Pourooshasb
 * @Samman Pandey
 */
public enum Location {
    HLL114("Hill Center, Busch"),
    ARC103("Allison Road Classroom, Busch"),
    BE_AUD("Beck Hall, Livingston"),
    TIL232("Till Hall, Livingston"),
    AB2225("Academic Building, College Avenue"),
    MU302("Murray Hall, College Avenue");

    private final String fullName;

    Location(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Get the campus part of the full location name.
     *
     * @return The campus name.
     */
    public String getCampus() {
        String[] parts = fullName.split(", ");
        if (parts.length > 1) {
            return parts[1].trim();
        }
        return "";
    }

    /**
     * Get the building part of the full location name.
     *
     * @return The building name.
     */
    public String getBuilding() {
        String[] parts = fullName.split(", ");
        if (parts.length > 0) {
            return parts[0].trim();
        }
        return "";
    }

    /**
     * Get a string representation of the location, including the enum
     * and the full name of the location.
     *
     * @return A string representation of the location.
     */
    @Override
    public String toString() {
        return "@" + name() + " (" + fullName + ")";
    }
}

