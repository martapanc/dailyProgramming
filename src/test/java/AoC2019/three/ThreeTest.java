package AoC2019.three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreeTest {

    private static final String INPUT1 = "src/test/java/AoC2019/three/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/three/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/three/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/three/input4";

    @Test
    public void testReadInput() {
        System.out.println(Three.readInput(INPUT1));
    }

    @Test
    public void testGetShortestDistances() {
        assertEquals(30, Three.getShortestDistances(Three.readInput(INPUT2)));
        assertEquals(410, Three.getShortestDistances(Three.readInput(INPUT3)));
        assertEquals(610, Three.getShortestDistances(Three.readInput(INPUT4)));
        assertEquals(37390, Three.getShortestDistances(Three.readInput(INPUT1)));
    }

    @Test
    public void testGetPathCoordinates() {
        assertEquals(6, Three.getPathCoordinates(Three.readInput(INPUT2)));
        assertEquals(135, Three.getPathCoordinates(Three.readInput(INPUT3)));
        assertEquals(159, Three.getPathCoordinates(Three.readInput(INPUT4)));
        assertEquals(1264, Three.getPathCoordinates(Three.readInput(INPUT1)));
    }
}
