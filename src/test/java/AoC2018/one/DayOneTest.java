package AoC2018.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayOneTest{

    public static final String INPUT1 = "src/test/java/AoC2018/one/input1";
    public static final String INPUT2 = "src/test/java/AoC2018/one/input2";

    @Test
    public void test_addNumberTest() {
        assertEquals(3, DayOne.frequencyCalculator("+1, +1, +1"));
        assertEquals(0, DayOne.frequencyCalculator("+1, +1, -2"));
        assertEquals(536, DayOne.frequencyCalculator(DayOne.readInput(INPUT1)));
    }

    @Test
    public void test_readInput() {
        assertEquals("+19, -15, +6, +6, +17, -18, +7, +14, ", DayOne.readInput(INPUT2));
    }

    @Test
    public void findFirstRepeatedFrequency() {
        assertEquals(10, DayOne.findFirstRepeatedFrequency("+3, +3, +4, -2, -4"));
        assertEquals(5, DayOne.findFirstRepeatedFrequency("-6, +3, +8, +5, -6"));
        assertEquals(0, DayOne.findFirstRepeatedFrequency("+1, -1"));
        assertEquals(14, DayOne.findFirstRepeatedFrequency("+7, +7, -2, -7, -4"));
        assertEquals(75108, DayOne.findFirstRepeatedFrequency(DayOne.readInput(INPUT1)));
    }
}