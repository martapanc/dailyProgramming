package AoC2019.sixteen;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SixteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/sixteen/input1";
    private static final String INPUT2 = "12345678";
    private static final String INPUT3 = "48226158";

    @Test
    public void testReadInput() {
        System.out.println(Sixteen.readInput(INPUT1));
        System.out.println(Sixteen.readStringInput(INPUT2));
    }

    @Test
    public void testComputeNthDigit() {
        assertEquals(8, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 2));
        assertEquals(4, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 1));
        assertEquals(2, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 3));
        assertEquals(2, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 4));
        assertEquals(6, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 5));
        assertEquals(1, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 6));
        assertEquals(5, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 7));
        assertEquals(8, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 8));
    }
}