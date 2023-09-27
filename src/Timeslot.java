public enum Timeslot {
    morning(10, 30, "am"), afternoon(2, 00, "pm"), evening(6, 30, "pm");

    private final int hour;
    private final int minute;

    private final String indicator;

    Timeslot(int hour, int minute, String indicator) {
        this.hour = hour;
        this.minute = minute;
        this.indicator = indicator;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }
    public String getIndicator(){
        return indicator;
    }
}

