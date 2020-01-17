package AoC2019.seventeen;

import AoC2019.nine.Nine;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeventeenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/seventeen/input1";

    @Test
    public void testReadInput() {
        System.out.println(Nine.readInput(INPUT1));
    }

    @Test
    public void testProcessInput() {
        Seventeen.processInput(Nine.readInput(INPUT1));
    }

    @Test
    public void testPrintMap() {
        Seventeen.printMap(Seventeen.processInput(Nine.readInput(INPUT1)));
    }

    @Test
    public void testGetIntersections() {
        System.out.println(Seventeen.getIntersections(Seventeen.processInput(Nine.readInput(INPUT1))));
    }

    @Test
    public void testMultiplyCoordinates() {
        assertEquals(141, Seventeen.multiplyCoordinates(Seventeen.getIntersections(Seventeen.processInput(Nine.readInput(INPUT1)))));
    }
}