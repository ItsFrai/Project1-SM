package eventcalendar;
/**
 * This enum represents what the inputs "Morining", "Afternoon" and "Evening" and
 * turns them into integer time
 * @Fraidoon Pourooshasb
 * @Samman Pandey
 */
public enum Timeslot {
    MORNING(10, 30, "am"), AFTERNOON(2, 0, "pm"), EVENING(6, 30, "pm");

    private final int hour;
    private final int minute;
    private final String indicator;

    /**
     * Constructs a new Timeslot with the specified hour, minute, and indicator.
     *
     * @param hour      The hour component of the timeslot.
     * @param minute    The minute component of the timeslot.
     * @param indicator The indicator (AM or PM) of the timeslot.
     */
    Timeslot(int hour, int minute, String indicator) {
        this.hour = hour;
        this.minute = minute;
        this.indicator = indicator;
    }

    /**
     * Gets the hour component of the timeslot.
     *
     * @return The hour component.
     */
    public int getHour(){
        return hour;
    }

    /**
     * Gets the minute component of the timeslot.
     *
     * @return The minute component.
     */
    public int getMinute(){
        return minute;
    }

    /**
     * Gets the indicator (AM or PM) of the timeslot.
     *
     * @return The indicator.
     */
    public String getIndicator(){
        return indicator;
    }

}

