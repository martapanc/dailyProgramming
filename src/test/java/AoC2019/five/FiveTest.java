package AoC2019.five;

import AoC2019.two.Two;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FiveTest {

    private static final String INPUT1 = "src/test/java/AoC2019/five/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/five/input2";

    @Test
    public void testReadInput() {
        // Reusing the read method written for Day2, as it's identical
        ArrayList<Integer> list = Two.readInput(INPUT1);
        assertEquals(678, list.size());
        System.out.println(list);
    }


    @Test
    public void testProcessInput() {
//        assertEquals(3500, Five.processInput(Two.readInput(INPUT2)));
        assertEquals(3500, Five.processInput(Two.readInput(INPUT1)));
    }
}
