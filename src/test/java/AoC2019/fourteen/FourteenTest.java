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
//        assertEquals(41, Fourteen.computeChemicals(Fourteen.readInput(INPUT1)));
        assertEquals(165, Fourteen.computeChemicals(Fourteen.readInput(INPUT2)));
        assertEquals(13312, Fourteen.computeChemicals(Fourteen.readInput(INPUT3)));
        assertEquals(180697, Fourteen.computeChemicals(Fourteen.readInput(INPUT4)));
        assertEquals(2210736, Fourteen.computeChemicals(Fourteen.readInput(INPUT5)));
//        assertEquals(64260, Fourteen.computeChemicals(Fourteen.readInput(INPUT6)));
    }

    @Test
    public void findConsumedWithQuantitiesFromMap() {
        System.out.println(Fourteen.findConsumedWithQuantitiesFromMap(new Chemical(3, "STKFG"), Fourteen.readInput(INPUT4)));
        System.out.println(Fourteen.findConsumedWithQuantitiesFromMap(new Chemical(6, "VPVL"), Fourteen.readInput(INPUT4)));
    }
}
