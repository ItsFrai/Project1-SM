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
    public String getCampus() {
        String[] parts = fullName.split(", ");
        if (parts.length > 1) {
            return parts[1].trim();
        }
        return "";
    }

    public String getBuilding() {
        String[] parts = fullName.split(", ");
        if (parts.length > 0) {
            return parts[0].trim();
        }
        return "";
    }

    @Override
    public String toString() {
        return "@" + name() + " (" + fullName + ")";
    }
}

