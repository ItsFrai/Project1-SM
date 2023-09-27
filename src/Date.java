public class Date implements Comparable<Date> {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    public static Date fromDateStr(String dateString) {
        String[] parts = dateString.split("/");
        if (parts.length == 3) {
            int month = Integer.parseInt(parts[0]);
            int day = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            return new Date(year, month, day);
        } else {
            throw new IllegalArgumentException("Invalid date format: " + dateString);
        }
    }

    public boolean isValid() {
        return true;
    }
    @Override
    public int compareTo(Date o) {
        return 0;
    }
}
