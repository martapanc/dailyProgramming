package AoC2019.one;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneTest {

    private static final String INPUT1 = "src/test/java/AoC2019/one/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/one/input2";

    @Test
    public void testCalculateFuelForModel() {
        assertEquals(2, One.calculateFuelForModel(12));
        assertEquals(2, One.calculateFuelForModel(14));
        assertEquals(654, One.calculateFuelForModel(1969));
        assertEquals(33583, One.calculateFuelForModel(100756));
    }

    @Test
    public void testCalculateTotalRecursiveFuel() {
        assertEquals(2, One.calculateRecursiveFuel(14));
        assertEquals(966, One.calculateRecursiveFuel(1969));
        assertEquals(50346, One.calculateRecursiveFuel(100756));
    }

    @Test
    public void testCalculateTotalFuel() {
        assertEquals(34241, One.calculateTotalFuel(INPUT2, false));
        assertEquals(3147032, One.calculateTotalFuel(INPUT1, false));
        assertEquals(4717699, One.calculateTotalFuel(INPUT1, true));
    }
}
