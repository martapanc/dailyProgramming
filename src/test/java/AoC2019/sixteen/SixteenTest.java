package AoC2019.sixteen;

import org.junit.Test;

public class SixteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/sixteen/input1";
    private static final String INPUT2 = "12345678";

    @Test
    public void testReadInput() {
        System.out.println(Sixteen.readInput(INPUT1));
        System.out.println(Sixteen.readStringInput(INPUT2));
    }

}