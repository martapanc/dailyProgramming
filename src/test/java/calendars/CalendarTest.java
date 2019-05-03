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
}