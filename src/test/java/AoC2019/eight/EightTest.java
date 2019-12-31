package AoC2019.eight;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EightTest {

    private static String INPUT1 = "src/test/java/AoC2019/eight/input1";
    private static String INPUT2 = "src/test/java/AoC2019/eight/input2";
    private static String INPUT3 = "src/test/java/AoC2019/eight/input3";
    private static String INPUT4 = "src/test/java/AoC2019/eight/input4";

    @Test
    public void testReadInput() {
        System.out.println(Eight.readInput(INPUT1, 25, 6));
        System.out.println(Eight.readInput(INPUT2, 3, 2));
        System.out.println(Eight.readInput(INPUT3, 2, 2));
    }

    @Test
    public void getBestLayer() {
        assertEquals(2480, Eight.getBestLayer(Eight.readInput(INPUT1, 25, 6)));
        assertEquals(2016, Eight.getBestLayer(Eight.readInput(INPUT4, 25, 6)));
    }

    @Test
    public void getRenderedImage() {
        assertEquals("0110", Eight.getRenderedImage(Eight.readInput(INPUT3, 2, 2), 2, 2));
        assertEquals("11110100011110010000100100001010001100101000010010001000101011100100001111001000" +
                        "0010010010100001001010000001001001010000100101111000100111001111010010",
                Eight.getRenderedImage(Eight.readInput(INPUT1, 25, 6), 25, 6));
        assertEquals("10010111100110011110100101001000010100100001010010111100010010000001001001010010" +
                        "0100010000010001001010010100001001010000100101001011110011001111001100",
                Eight.getRenderedImage(Eight.readInput(INPUT4, 25, 6), 25, 6));
    }
}