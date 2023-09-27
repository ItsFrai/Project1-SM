public enum Timeslot {
    morning(10, 30), afternoon(14, 0), evening(18, 30);

    private final int hour;
    private final int minute;

    Timeslot(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    private int getHour(){
        return hour;
    }

    private int getMinute(){
        return minute;
    }
}
