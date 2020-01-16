package AoC2019.sixteen;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SixteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/sixteen/input1";
    private static final String INPUT2 = "12345678";
    private static final String INPUT3 = "48226158";
    private static final String INPUT4 = "34040438";
    private static final String INPUT5 = "03415518";
    private static final String INPUT6 = "01029498";
    private static final String INPUT7 = "80871224585914546619083218645595";


    @Test
    public void testReadInput() {
        System.out.println(Sixteen.readInput(INPUT1));
        System.out.println(Sixteen.readStringInput(INPUT2));
    }

    @Test
    public void testComputeNthDigit() {
        assertEquals(4, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 1));
        assertEquals(8, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 2));
        assertEquals(2, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 3));
        assertEquals(2, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 4));
        assertEquals(6, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 5));
        assertEquals(1, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 6));
        assertEquals(5, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 7));
        assertEquals(8, Sixteen.computeNthDigit(Sixteen.readStringInput(INPUT2), 8));
    }

    @Test
    public void testComputePhase() {
        assertEquals(INPUT3, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 1));

        assertEquals(INPUT4, Sixteen.computePhase(Sixteen.readStringInput(INPUT3), 1));
        assertEquals(INPUT4, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 2));
        assertEquals(INPUT5, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 3));
        assertEquals(INPUT6, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 4));

        assertEquals("24176176480919046114038763195595", Sixteen.computePhase(Sixteen.readStringInput(INPUT7), 100));
//        assertEquals("24176176480919046114038763195595", Sixteen.computePhase(Sixteen.readInput(INPUT1), 100));
    }
}