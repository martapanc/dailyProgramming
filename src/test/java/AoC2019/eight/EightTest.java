package AoC2019.eight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EightTest {

    private static String INPUT1 = "src/test/java/AoC2019/eight/input1";
    private static String INPUT2 = "src/test/java/AoC2019/eight/input2";
    private static String INPUT3 = "src/test/java/AoC2019/eight/input3";

    @Test
    public void testReadInput() {
        System.out.println(Eight.readInput(INPUT1, 25, 6));
        System.out.println(Eight.readInput(INPUT2, 3, 2));
        System.out.println(Eight.readInput(INPUT3, 2, 2));
    }

    @Test
    public void getBestLayer() {
        assertEquals(2480, Eight.getBestLayer(Eight.readInput(INPUT1, 25, 6)));
    }

    @Test
    public void getRenderedImage() {
        assertEquals("0110", Eight.getRenderedImage(Eight.readInput(INPUT3, 2, 2), 2, 2));
        assertEquals("11110100011110010000100100001010001100101000010010001000101011100100001111001000" +
                        "0010010010100001001010000001001001010000100101111000100111001111010010",
                Eight.getRenderedImage(Eight.readInput(INPUT1, 25, 6), 25, 6));
    }
}