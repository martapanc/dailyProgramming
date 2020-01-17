package AoC2019.seventeen;

import AoC2019.nine.Nine;
import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeventeenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/seventeen/input1";
    private static final ArrayList<Long> READ_INPUT = Nine.readInput(INPUT1);
    private static final List<Point> INTERSECTIONS = Seventeen.getIntersections(Seventeen.processInput(READ_INPUT));

    @Test
    public void testReadInput() {
        System.out.println(READ_INPUT);
    }

    @Test
    public void testProcessInput() {
        Seventeen.processInput(READ_INPUT);
    }

    @Test
    public void testPrintMap() {
        Seventeen.printMap(Seventeen.processInput(READ_INPUT));
    }

    @Test
    public void testGetIntersections() {
        System.out.println(INTERSECTIONS);
    }

    @Test
    public void testMultiplyCoordinates() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(2, 2));
        pointList.add(new Point(4, 2));
        pointList.add(new Point(4, 6));
        pointList.add(new Point(4, 10));
        assertEquals(76, Seventeen.multiplyCoordinates(pointList));
        assertEquals(7720, Seventeen.multiplyCoordinates(INTERSECTIONS));
    }
}