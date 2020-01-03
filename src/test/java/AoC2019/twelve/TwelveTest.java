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
        Twelve.computeMovements(Twelve.readInput(INPUT2), 2772);
        Twelve.computeMovements(Twelve.readInput(INPUT2), 5544);
//        Twelve.computeMovements(Twelve.readInput(INPUT3), 4686774924L); // Should take ~ 40 mins - run at your own risk
    }

    @Test
    public void testComputeTotalEnergy() {
        assertEquals(179, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT2), 10));
        assertEquals(1940, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT3), 100));
        assertEquals(9958, Twelve.computeTotalEnergyAfterNSteps(Twelve.readInput(INPUT1), 1000));
    }

    @Test
    public void testFindMoonCyclePeriod() {
        assertEquals(924, Twelve.findMoonCyclePeriod(0, Twelve.readInput(INPUT2)));
        assertEquals(617, Twelve.findMoonCyclePeriod(1, Twelve.readInput(INPUT2)));
        assertEquals(2772, Twelve.findMoonCyclePeriod(2, Twelve.readInput(INPUT2)));
        assertEquals(924, Twelve.findMoonCyclePeriod(3, Twelve.readInput(INPUT2)));

        assertEquals(3084600, Twelve.findMoonCyclePeriod(0, Twelve.readInput(INPUT3)));
        assertEquals(1026086, Twelve.findMoonCyclePeriod(1, Twelve.readInput(INPUT3)));
        assertEquals(194634, Twelve.findMoonCyclePeriod(2, Twelve.readInput(INPUT3)));
        assertEquals(7661302, Twelve.findMoonCyclePeriod(3, Twelve.readInput(INPUT3)));
    }

    @Test
    public void testFindMoonCyclesPeriod() {
        Twelve.findMoonCyclesPeriod(0, 3000, Twelve.readInput(INPUT2));
        Twelve.findMoonCyclesPeriod(1, 3000, Twelve.readInput(INPUT2));
        Twelve.findMoonCyclesPeriod(2, 3000, Twelve.readInput(INPUT2));
        Twelve.findMoonCyclesPeriod(3, 3000, Twelve.readInput(INPUT2));

        Twelve.findMoonCyclesPeriod(0, 4686775000L, Twelve.readInput(INPUT3));
        Twelve.findMoonCyclesPeriod(1, 4686775000L, Twelve.readInput(INPUT3));
        Twelve.findMoonCyclesPeriod(2, 4686775000L, Twelve.readInput(INPUT3));
        Twelve.findMoonCyclesPeriod(3, 4686775000L, Twelve.readInput(INPUT3));
    }
}