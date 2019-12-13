package AoC2019.six;

import org.junit.Test;

public class SixTest {

    private static final String INPUT1 = "src/test/java/AoC2019/six/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/six/input2";

    @Test
    public void testReadInput() {
        System.out.println(Six.readInput(INPUT1));
        System.out.println(Six.readInput(INPUT2));
    }
}