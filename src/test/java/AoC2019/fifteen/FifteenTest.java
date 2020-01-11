package AoC2019.fifteen;

import AoC2019.nine.Nine;
import org.junit.Test;

public class FifteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/fifteen/input1";

    @Test
    public void testReadInput() {
        System.out.println(Nine.readInput(INPUT1));
    }

    @Test
    public void testProcessInput() {
        System.out.println(Fifteen.processInput(Nine.readInput(INPUT1), 1));
//        System.out.println(Fifteen.processInput(Nine.readInput(INPUT1), 2));
//        System.out.println(Fifteen.processInput(Nine.readInput(INPUT1), 3));
//        System.out.println(Fifteen.processInput(Nine.readInput(INPUT1), 4));
    }
}
