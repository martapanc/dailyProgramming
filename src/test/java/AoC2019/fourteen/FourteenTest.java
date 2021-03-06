package AoC2019.fourteen;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FourteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/fourteen/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/fourteen/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/fourteen/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/fourteen/input4";
    private static final String INPUT5 = "src/test/java/AoC2019/fourteen/input5";
    private static final String INPUT6 = "src/test/java/AoC2019/fourteen/input6";

    @Test
    public void testReadInput() {
        Map<Chemical, List<Chemical>> map = Fourteen.readInput(INPUT1);
        System.out.println(map);
        assertEquals(6, map.size());

        map = Fourteen.readInput(INPUT2);
        System.out.println(map);
        assertEquals(7, map.size());

        map = Fourteen.readInput(INPUT6);
        System.out.println(map);
        assertEquals(56, map.size());
    }

    @Test
    public void computeChemicals() {
        assertEquals(31, Fourteen.computeChemicals(Fourteen.readInput(INPUT1)));
        assertEquals(165, Fourteen.computeChemicals(Fourteen.readInput(INPUT2)));
        assertEquals(13312, Fourteen.computeChemicals(Fourteen.readInput(INPUT3)));
        assertEquals(180697, Fourteen.computeChemicals(Fourteen.readInput(INPUT4)));
        assertEquals(2210736, Fourteen.computeChemicals(Fourteen.readInput(INPUT5)));
        assertEquals(365768, Fourteen.computeChemicals(Fourteen.readInput(INPUT6)));
    }

    @Test
    public void computeMaxFuel() {
//        assertEquals(82892753, Fourteen.computeMaxFuel(Fourteen.readInput(INPUT3), 1000000000000L));
//        assertEquals(5586022, Fourteen.computeMaxFuel(Fourteen.readInput(INPUT4), 1000000000000L));
        assertEquals(460664, Fourteen.computeMaxFuel(Fourteen.readInput(INPUT5), 1000000000000L));
        assertEquals(4606, Fourteen.computeMaxFuel(Fourteen.readInput(INPUT5), 10000000000L));
//        assertEquals(3756877, Fourteen.computeMaxFuel(Fourteen.readInput(INPUT6), 1000000000000L));
    }
}
