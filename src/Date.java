import java.util.Calendar;

public class Date implements Comparable<Date> {

    private final int year;
    private final int month;
    private final int day;

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
        // Check if the date is valid (month between 1 and 12, day within the valid range for the month)
        return month >= 1 && month <= 12 && day >= 1 && day <= getDaysInMonth();
    }

    public boolean isFutureDate() {
        // Get the current date
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

        return year < currentYear || (year == currentYear && month < currentMonth)
                || (year == currentYear && month == currentMonth && day < currentDay);
    }

    public boolean isMoreThan6MonthsAway() {
        // Get the current date
        Calendar currentDate = Calendar.getInstance();
        int currentYear = currentDate.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;

        int futureYear = currentYear;
        int futureMonth = currentMonth + 6;
        if (futureMonth > 12) {
            futureYear += 1;
            futureMonth -= 12;
        }
        // Compare the event date with the calculated future date
        return year > futureYear || (year == futureYear && month > futureMonth);
    }

    private int getDaysInMonth() {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear() && month == 2) {
            return 29; // February in a leap year
        }
        return daysInMonth[month];
    }

    private boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    @Override
    public int compareTo(Date o) {
        // Implement comparison logic here if needed
        return 0;
    }

    public static void main(String[] args) {
        testDayinFeb_nonleap();
        testDayinFeb_leap();
        testMonth();
        }

   private static void testDayinFeb_nonleap() {



        testingresults();
   }

   private static void testDayinFeb_leap() {

        testingresults();
   }

   private static void testMonth(){

        testingresults();
   }
   private static void testingresults() {

   }
}
