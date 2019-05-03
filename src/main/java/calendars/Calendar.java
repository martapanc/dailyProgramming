package calendars;

// https://www.reddit.com/r/dailyprogrammer/comments/b0nuoh/20190313_challenge_376_intermediate_the_revised/

/**
 * Gregorian Calendar rules:
 *  if (year is not divisible by 4) then (it is a common year)
 *  else if (year is not divisible by 100) then (it is a leap year)
 *  else if (year is not divisible by 400) then (it is a common year)
 *  else (it is a leap year)
 *
 * Revised Julian Calendar:
 *  * Years that are evenly divisible by 4 are leap years.
 *  * Exception: Years that are evenly divisible by 100 are not leap years.
 *  * Exception to the exception: Years for which the remainder when divided by 900 is either 200 or 600 are leap years.
 * */

public class Calendar {

    public enum CalendarType {
        GREGORIAN,
        REVISED_JULIAN
    }

    static boolean isLeapInGregorianCalendar(long year) {

        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 400 == 0;
    }

    static boolean isLeapInRevisedJulianCalendar(long year) {

        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else return year % 900 == 200 || year % 900 == 600;
    }

    static long howManyLeapYearsBetween(long year1, long year2, CalendarType calendarType) {
        long leapYearCount = 0;
        for (long y = year1; y < year2; y++) {
            if (calendarType == CalendarType.GREGORIAN) {
                if (isLeapInGregorianCalendar(y)) {
                    leapYearCount += 1;
                }
            } else {
                if (isLeapInRevisedJulianCalendar(y)) {
                    leapYearCount += 1;
                }
            }
        }

        return leapYearCount;
    }

    /**
     * Every 900-year period has a fixed number of leap years. An optimised solution requires multiplying years/900
     * by 218 (number of leap years in [0, 900) ) and compute how many leap years the remainder contains.
     * */
    static long howManyLeapYearsBetween_better(long year1, long year2) {
        long leapYearCount = 0;

        long first_even = ( Math.floorDiv(year1, 900) + 1 ) * 900;
        long last_even = ( Math.floorDiv(year2, 900) - 1 ) * 900;

        long middle_periods = (last_even - first_even) / 900;

        leapYearCount += middle_periods * 218;
        leapYearCount += howManyLeapYearsBetween(year1, first_even, CalendarType.REVISED_JULIAN);
        leapYearCount += howManyLeapYearsBetween(last_even, year2, CalendarType.REVISED_JULIAN);

        return leapYearCount;
    }
}
