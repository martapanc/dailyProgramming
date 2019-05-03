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
}
