package AoC2019.six;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SixTest {

    private static final String INPUT1 = "src/test/java/AoC2019/six/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/six/input2";

    @Test
    public void testReadInput() {
        System.out.println(Six.readInput(INPUT1));
        System.out.println(Six.readInput(INPUT2));
    }

    @Test
    public void testGetOrbitMap() {
        System.out.println(Six.getOrbitMap(Six.readInput(INPUT1)));
    }

    @Test
    public void testGetCompleteOrbitMap() {
        Map<String, Set<String>> completeOrbitMap = Six.getCompleteOrbitMap(Six.readInput(INPUT1));
        System.out.println(completeOrbitMap);
        assertEquals(42, Six.getListSizeSum(completeOrbitMap));

        Map<String, Set<String>> completeOrbitMap2 = Six.getCompleteOrbitMap(Six.readInput(INPUT2));
        System.out.println(completeOrbitMap2);
        assertEquals(119831, Six.getListSizeSum(completeOrbitMap2));
    }

    @Test
    public void calculateJumps() {
        Map<String, Set<String>> completeOrbitMap2 = Six.getCompleteOrbitMap(Six.readInput(INPUT2));
        System.out.println(Six.calculateJumps(completeOrbitMap2));
    }
}