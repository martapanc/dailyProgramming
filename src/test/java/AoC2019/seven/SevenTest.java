package AoC2019.seven;

import AoC2019.two.Two;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SevenTest {

    private static String INPUT1 = "src/test/java/AoC2019/seven/input1";
    private static String INPUT2 = "src/test/java/AoC2019/seven/input2";
    private static String INPUT3 = "src/test/java/AoC2019/seven/input3";
    private static String INPUT4 = "src/test/java/AoC2019/seven/input4";

    @Test
    public void testReadInput() {
        System.out.println(Two.readInput(INPUT1));
        System.out.println(Two.readInput(INPUT2));
        System.out.println(Two.readInput(INPUT3));
        System.out.println(Two.readInput(INPUT4));
    }

    @Test
    public void testProcessInput() {
        assertEquals(4, Seven.processInput(Two.readInput(INPUT1), 4, 0));
        assertEquals(43, Seven.processInput(Two.readInput(INPUT1), 3, 4));
        assertEquals(432, Seven.processInput(Two.readInput(INPUT1), 2, 43));
        assertEquals(4321, Seven.processInput(Two.readInput(INPUT1), 1, 432));
        assertEquals(43210, Seven.processInput(Two.readInput(INPUT1), 0, 4321));

        assertEquals(5, Seven.processInput(Two.readInput(INPUT2), 0, 0));
        assertEquals(54, Seven.processInput(Two.readInput(INPUT2), 1, 5));
        assertEquals(543, Seven.processInput(Two.readInput(INPUT2), 2, 54));
        assertEquals(5432, Seven.processInput(Two.readInput(INPUT2), 3, 543));
        assertEquals(54321, Seven.processInput(Two.readInput(INPUT2), 4, 5432));

        assertEquals(6, Seven.processInput(Two.readInput(INPUT3), 1, 0));
        assertEquals(65, Seven.processInput(Two.readInput(INPUT3), 0, 6));
        assertEquals(652, Seven.processInput(Two.readInput(INPUT3), 4, 65));
        assertEquals(6521, Seven.processInput(Two.readInput(INPUT3), 3, 652));
        assertEquals(65210, Seven.processInput(Two.readInput(INPUT3), 2, 6521));
    }
}