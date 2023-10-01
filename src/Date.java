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
        }
        return null;
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
        int currentDay = currentDate.get(Calendar.DAY_OF_MONTH);

        int futureYear = currentYear;
        int futureMonth = currentMonth + 6;
        if (futureMonth > 12) {
            futureYear += 1;
            futureMonth -= 12;
        }
        return year > futureYear || (year == futureYear && month > futureMonth || (year == futureYear && month == futureMonth && currentDay < day));
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
    public int compareTo(Date x) {
        if (this.year > x.year) {
            return 1;
        } else if (this.year < x.year) {
            return -1;
        } else { // Years are equal, so compare months
            if (this.month > x.month) {
                return 1;
            } else if (this.month < x.month) {
                return -1;
            } else { // Months are equal, so compare days
                if (this.day > x.day) {
                    return 1;
                } else if (this.day < x.day) {
                    return -1;
                } else { // Years, months, and days are equal
                    return 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        testDayinFeb_nonleap();
        testDayinFeb_leap();
        testMonth();
        }

   private static void testDayinFeb_nonleap() {
        Date date = new Date(2023, 2, 29);
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.println("**Test case #1: # of days in Feb. in a non-leap year is 28");
        testingresults(date,expectedOutput,actualOutput);
   }

   private static void testDayinFeb_leap() {
       Date date = new Date(2020, 2, 30);
       boolean expectedOutput = false;
       boolean actualOutput = date.isValid();
       System.out.println("**Test case #2: # of days in Feb. in a leap year is 29");
       testingresults(date,expectedOutput,actualOutput);
   }

   private static void testMonth(){
       Date date = new Date(2023, 14, 25);
       boolean expectedOutput = false;
       boolean actualOutput = date.isValid();
       System.out.println("**Test case #3: Month value should be between 1 and 12");
       testingresults(date,expectedOutput,actualOutput);
   }
    private static void testingresults(Date date, boolean expected, boolean actual) {
        System.out.println("Date Input: " + date);
        System.out.println("Expected Output: " + expected);
        System.out.println("Actual Output: " + actual);

        if (expected == actual) {
            System.out.println("Test Result: Passed\n");
        } else {
            System.out.println("Test Result: Failed\n");
        }
    }
}
