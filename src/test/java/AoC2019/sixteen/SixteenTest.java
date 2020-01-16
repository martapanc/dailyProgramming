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
        assertEquals(INPUT3, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 1, true));

        assertEquals(INPUT4, Sixteen.computePhase(Sixteen.readStringInput(INPUT3), 1, true));
        assertEquals(INPUT4, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 2, true));
        assertEquals(INPUT5, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 3, true));
        assertEquals(INPUT6, Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 4, true));

        assertEquals("24176176", Sixteen.computePhase(Sixteen.readStringInput(INPUT7), 100, true));
        assertEquals("77038830", Sixteen.computePhase(Sixteen.readInput(INPUT1), 100, true));
//        assertEquals("77038830", Sixteen.computePhase(Sixteen.tenThousandTimesList(Sixteen.readInput(INPUT1)), 1, true));

        Sixteen.computePhase(Sixteen.readStringInput(INPUT7), 100, false);
        Sixteen.computePhase(Sixteen.readStringInput(INPUT2), 100, false);
    }

    @Test
    public void testCreateTenThousandTimesList(){
        assertEquals(80000, Sixteen.tenThousandTimesList(Sixteen.readStringInput("12345678")).size());
        assertEquals(320000, Sixteen.tenThousandTimesList(Sixteen.readStringInput("03036732577212944063491565474664")).size());
        assertEquals(6500000, Sixteen.tenThousandTimesList(Sixteen.readInput(INPUT1)).size());
    }

}