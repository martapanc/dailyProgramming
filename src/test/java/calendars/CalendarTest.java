package calendars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    @Test
    void isLeapInGregorianCalendar() {
        assertFalse(Calendar.isLeapInGregorianCalendar(1995));
        assertTrue(Calendar.isLeapInGregorianCalendar(1996));
        assertTrue(Calendar.isLeapInGregorianCalendar(2000));
        assertFalse(Calendar.isLeapInGregorianCalendar(2100));
    }

    @Test
    void isLeapInRevisedJulianCalendar() {
        assertFalse(Calendar.isLeapInRevisedJulianCalendar(1995));
        assertTrue(Calendar.isLeapInRevisedJulianCalendar(1996));
        assertTrue(Calendar.isLeapInRevisedJulianCalendar(2000));
        assertFalse(Calendar.isLeapInRevisedJulianCalendar(2100));
        assertTrue(Calendar.isLeapInRevisedJulianCalendar(2400));
    }

    @Test
    void howManyLeapYearsBetween() {
        assertEquals(1, Calendar.howManyLeapYearsBetween(1995, 1999, Calendar.CalendarType.REVISED_JULIAN));
        assertEquals(2, Calendar.howManyLeapYearsBetween(1995, 2001, Calendar.CalendarType.REVISED_JULIAN));
        assertEquals(3, Calendar.howManyLeapYearsBetween(1995, 2005, Calendar.CalendarType.REVISED_JULIAN));
        assertEquals(0, Calendar.howManyLeapYearsBetween(1599, 1604, Calendar.CalendarType.REVISED_JULIAN));
        assertEquals(1, Calendar.howManyLeapYearsBetween(1995, 1999, Calendar.CalendarType.GREGORIAN));

        assertEquals(970, Calendar.howManyLeapYearsBetween(0, 4000, Calendar.CalendarType.GREGORIAN));
        assertEquals(969, Calendar.howManyLeapYearsBetween(0, 4000, Calendar.CalendarType.REVISED_JULIAN));
    }

    @Test
    void testHowManyLeapYearsBetween_better() {
        assertEquals(1, Calendar.howManyLeapYearsBetween_better(1995, 1999));
        assertEquals(2, Calendar.howManyLeapYearsBetween_better(1995, 2001));
        assertEquals(3, Calendar.howManyLeapYearsBetween_better(1995, 2005));
        assertEquals(0, Calendar.howManyLeapYearsBetween_better(1599, 1604));
        assertEquals(1, Calendar.howManyLeapYearsBetween_better(2016, 2017));
        assertEquals(1, Calendar.howManyLeapYearsBetween_better(2000, 2001));
        assertEquals(0, Calendar.howManyLeapYearsBetween_better(123456, 123456));
        assertEquals(1077, Calendar.howManyLeapYearsBetween_better(1234, 5678));
        assertEquals(1881475, Calendar.howManyLeapYearsBetween_better(123456, 7891011));
        assertEquals(288412747246240L, Calendar.howManyLeapYearsBetween_better(123456789101112L, 1314151617181920L));
    }
}