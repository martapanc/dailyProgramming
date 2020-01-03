package AoC2019.twelve;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwelveTest {

    private static final String INPUT1 = "src/test/java/AoC2019/twelve/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/twelve/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/twelve/input3";

    @Test
    public void readInput() {
        System.out.println(Twelve.readInput(INPUT1));
        System.out.println(Twelve.readInput(INPUT2));
    }

    @Test
    public void testComputeMovements() {
        Twelve.computeMovements(Twelve.readInput(INPUT2), 10);
        Twelve.computeMovements(Twelve.readInput(INPUT3), 100);
    }

    @Test
    public void testComputeTotalEnergy() {
        assertEquals(179, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT2), 10));
        assertEquals(1940, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT3), 100));
        assertEquals(9958, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT1), 1000));
    }
}