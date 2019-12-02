package AoC2019.two;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoTest {

    private static final String INPUT1 = "src/test/java/AoC2019/two/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/two/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/two/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/two/input4";
    private static final String INPUT5 = "src/test/java/AoC2019/two/input5";
    private static final String INPUT1_2 = "src/test/java/AoC2019/two/input1_2";

    @Test
    public void testReadInput() {
        System.out.println(Two.readInput(INPUT1));
    }

    @Test
    public void processInput() {
        assertEquals(3500, Two.processInput(Two.readInput(INPUT2)));
        assertEquals(2, Two.processInput(Two.readInput(INPUT3)));
        assertEquals(2, Two.processInput(Two.readInput(INPUT4)));
        assertEquals(30, Two.processInput(Two.readInput(INPUT5)));
        assertEquals(5866714, Two.processInput(Two.readInput(INPUT1)));
    }

    @Test
    public void findPair() {
        assertEquals(5208, Two.findPair(Two.readInput(INPUT1_2)));
    }
}
