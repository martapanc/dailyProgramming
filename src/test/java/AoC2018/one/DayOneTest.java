package AoC2018.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayOneTest{

    private DayOne dayOne = new DayOne();

    @Test
    public void addNumberTest() {
        assertEquals(3, dayOne.frequencyCalculator("+1, +1, +1"));
        assertEquals(0, dayOne.frequencyCalculator("+1, +1, -2"));
    }

}