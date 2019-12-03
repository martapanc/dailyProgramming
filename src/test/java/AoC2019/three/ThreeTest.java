package AoC2019.three;

import org.junit.Test;

import java.awt.*;

public class ThreeTest {

    private static final String INPUT1 = "src/test/java/AoC2019/three/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/three/input2";

    @Test
    public void testReadInput() {
        System.out.println(Three.readInput(INPUT1));
    }

    @Test
    public void testGetPathCoordinates() {
        System.out.println(Three.getPathCoordinates(Three.readInput(INPUT2)));
    }
}
