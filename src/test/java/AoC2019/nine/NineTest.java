package AoC2019.nine;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class NineTest {

    private static final String INPUT1 = "src/test/java/AoC2019/nine/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/nine/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/nine/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/nine/input4";

    private static final String INPUT1_five = "src/test/java/AoC2019/five/input1";
    private static final String INPUT2_five = "src/test/java/AoC2019/five/input2";
    private static final String INPUT2_2_five = "src/test/java/AoC2019/five/input2_2";
    private static final String INPUT3_five = "src/test/java/AoC2019/five/input3";
    private static final String INPUT3_2_five = "src/test/java/AoC2019/five/input3_2";
    private static final String INPUT4_five = "src/test/java/AoC2019/five/input4";
    private static final String INPUT5_five = "src/test/java/AoC2019/five/input5";
    private static final String INPUT6_five = "src/test/java/AoC2019/five/input6";

    @Test
    public void testReadInput() {
        ArrayList<Long> list = Nine.readInput(INPUT1);
        assertEquals(16, list.size());
        System.out.println(list);
    }

    @Test
    public void testProcessInput() {
//        assertEquals(1, Nine.processInput(Nine.readInput(INPUT1), 1));
        assertEquals(1219070632396864L, Nine.processInput(Nine.readInput(INPUT2), 1));
        assertEquals(1125899906842624L, Nine.processInput(Nine.readInput(INPUT3), 1));
        assertEquals(2377080455L, Nine.processInput(Nine.readInput(INPUT4), 1));
    }

    // Check that the code still work for previous versions
    @Test
    public void testProcessInput_Regression() {
        assertEquals(7988899, Nine.processInput(Nine.readInput(INPUT1_five), 1));
        assertEquals(13758663, Nine.processInput(Nine.readInput(INPUT1_five), 5));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT2_five), 7));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT2_five), 8));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT2_2_five), 8));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT2_2_five), 7));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT3_five), 7));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT3_five), 8));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT3_2_five), 8));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT3_2_five), 7));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT4_five), 0));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT4_five), 2));

        assertEquals(0, Nine.processInput(Nine.readInput(INPUT5_five), 0));
        assertEquals(1, Nine.processInput(Nine.readInput(INPUT5_five), 2));

        assertEquals(999, Nine.processInput(Nine.readInput(INPUT6_five), 7));
        assertEquals(1000, Nine.processInput(Nine.readInput(INPUT6_five), 8));
        assertEquals(1001, Nine.processInput(Nine.readInput(INPUT6_five), 9));
    }
}