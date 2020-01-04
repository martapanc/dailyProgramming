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
    public void testFindAxisCyclePeriod() {
        long xAxisCyclePeriod = Twelve.findXAxisCyclePeriod(Twelve.readInput(INPUT2));
        long yAxisCyclePeriod = Twelve.findYAxisCyclePeriod(Twelve.readInput(INPUT2));
        long zAxisCyclePeriod = Twelve.findZAxisCyclePeriod(Twelve.readInput(INPUT2));

        assertEquals(18, xAxisCyclePeriod);
        assertEquals(28, yAxisCyclePeriod);
        assertEquals(44, zAxisCyclePeriod);

        assertEquals(2772, MathUtil.lcm(new long[]{xAxisCyclePeriod, yAxisCyclePeriod, zAxisCyclePeriod}));

        xAxisCyclePeriod = Twelve.findXAxisCyclePeriod(Twelve.readInput(INPUT3));
        yAxisCyclePeriod = Twelve.findYAxisCyclePeriod(Twelve.readInput(INPUT3));
        zAxisCyclePeriod = Twelve.findZAxisCyclePeriod(Twelve.readInput(INPUT3));
        assertEquals(2028, xAxisCyclePeriod);
        assertEquals(5898, yAxisCyclePeriod);
        assertEquals(4702, zAxisCyclePeriod);

        assertEquals(4686774924L, MathUtil.lcm(new long[]{xAxisCyclePeriod, yAxisCyclePeriod, zAxisCyclePeriod}));

        xAxisCyclePeriod = Twelve.findXAxisCyclePeriod(Twelve.readInput(INPUT1));
        yAxisCyclePeriod = Twelve.findYAxisCyclePeriod(Twelve.readInput(INPUT1));
        zAxisCyclePeriod = Twelve.findZAxisCyclePeriod(Twelve.readInput(INPUT1));
        assertEquals(28482, xAxisCyclePeriod);
        assertEquals(231614, yAxisCyclePeriod);
        assertEquals(193052, zAxisCyclePeriod);

        assertEquals(318382803780324L, MathUtil.lcm(new long[]{xAxisCyclePeriod, yAxisCyclePeriod, zAxisCyclePeriod}));
    }
}