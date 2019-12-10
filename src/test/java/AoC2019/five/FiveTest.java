package AoC2019.five;

import AoC2019.two.Two;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FiveTest {

    private static final String INPUT1 = "src/test/java/AoC2019/five/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/five/input2";
    private static final String INPUT2_2 = "src/test/java/AoC2019/five/input2_2";
    private static final String INPUT3 = "src/test/java/AoC2019/five/input3";
    private static final String INPUT3_2 = "src/test/java/AoC2019/five/input3_2";
    private static final String INPUT4 = "src/test/java/AoC2019/five/input4";
    private static final String INPUT5 = "src/test/java/AoC2019/five/input5";
    private static final String INPUT6 = "src/test/java/AoC2019/five/input6";

    @Test
    public void testReadInput() {
        // Reusing the read method written for Day2, as it's identical
        ArrayList<Integer> list = Two.readInput(INPUT1);
        assertEquals(678, list.size());
        System.out.println(list);
    }


    @Test
    public void testProcessInput() {
        assertEquals(7988899, Five.processInput(Two.readInput(INPUT1), 1));
        assertEquals(13758663, Five.processInput(Two.readInput(INPUT1), 5));

        assertEquals(0, Five.processInput(Two.readInput(INPUT2), 7));
        assertEquals(1, Five.processInput(Two.readInput(INPUT2), 8));

        assertEquals(0, Five.processInput(Two.readInput(INPUT2_2), 8));
        assertEquals(1, Five.processInput(Two.readInput(INPUT2_2), 7));

        assertEquals(0, Five.processInput(Two.readInput(INPUT3), 7));
        assertEquals(1, Five.processInput(Two.readInput(INPUT3), 8));

        assertEquals(0, Five.processInput(Two.readInput(INPUT3_2), 8));
        assertEquals(1, Five.processInput(Two.readInput(INPUT3_2), 7));

        assertEquals(0, Five.processInput(Two.readInput(INPUT4), 0));
        assertEquals(1, Five.processInput(Two.readInput(INPUT4), 2));

        assertEquals(0, Five.processInput(Two.readInput(INPUT5), 0));
        assertEquals(1, Five.processInput(Two.readInput(INPUT5), 2));

        assertEquals(999, Five.processInput(Two.readInput(INPUT6), 7));
        assertEquals(1000, Five.processInput(Two.readInput(INPUT6), 8));
        assertEquals(1001, Five.processInput(Two.readInput(INPUT6), 9));

    }
}
