package AoC2019.five;

import AoC2019.two.Two;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FiveTest {

    private static final String INPUT1 = "src/test/java/AoC2019/five/input1";

    @Test
    public void testReadInput() {
        ArrayList<Integer> list = Two.readInput(INPUT1);
        assertEquals(678, list.size());
        System.out.println(list);
    }
}
