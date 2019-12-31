package AoC2019.eight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EightTest {

    private static String INPUT1 = "src/test/java/AoC2019/eight/input1";
    private static String INPUT2 = "src/test/java/AoC2019/eight/input2";

    @Test
    public void testReadInput() {
        System.out.println(Eight.readInput(INPUT1, 25, 6));
        System.out.println(Eight.readInput(INPUT2, 3, 2));
    }

    @Test
    public void getBestLayer() {
        assertEquals(2480, Eight.getBestLayer(Eight.readInput(INPUT1, 25, 6)));
    }
}