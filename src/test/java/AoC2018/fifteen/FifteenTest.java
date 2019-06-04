package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FifteenTest {

    private final String input1 = "src/test/java/AoC2018/fifteen/input1";
    private final String input_flood = "src/test/java/AoC2018/fifteen/input_flood";

    @Test
    public void testReadInputAndPrintMatrix(){
        Thirteen.printMatrix(Thirteen.readInput(input1, 9,9));
    }

    @Test
    public void getInitialUnitPositions() {
        List<Unit> unitList = new ArrayList<>();
        unitList.add(new Goblin(new Point(1, 1)));
        unitList.add(new Goblin(new Point(4, 1)));
        unitList.add(new Goblin(new Point(7, 1)));
        unitList.add(new Goblin(new Point(1, 4)));
        unitList.add(new Elf(new Point(4, 4)));
        unitList.add(new Goblin(new Point(7, 4)));
        unitList.add(new Goblin(new Point(1, 7)));
        unitList.add(new Goblin(new Point(4, 7)));
        unitList.add(new Goblin(new Point(7, 7)));

        List<Unit> actual = Fifteen.getInitialUnitPositions(Thirteen.readInput(input1, 9,9));
        IntStream.range(0, unitList.size()).forEach(i -> assertEquals(unitList.get(i).toString(), actual.get(i).toString()));
    }

    @Test
    public void testFindPossibleTargets() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(4, 3));
        pointList.add(new Point(5, 4));
        pointList.add(new Point(4, 5));
        pointList.add(new Point(3, 4));

        assertEquals(pointList, Fifteen.findPossibleTargets(
                new Goblin(new Point(1,1)),
                Fifteen.getInitialUnitPositions(Thirteen.readInput(input1, 9, 9)),
                Thirteen.readInput(input1, 9, 9)
        ));
    }

    @Test
    public void testGetAccessiblePoints() {
        List<Point> accessiblePoints = new ArrayList<>();
        accessiblePoints.add(new Point(2,1));
        accessiblePoints.add(new Point(3,1));
        accessiblePoints.add(new Point(1,2));
        accessiblePoints.add(new Point(2,2));
        accessiblePoints.add(new Point(3,2));
        accessiblePoints.add(new Point(1,3));
        accessiblePoints.add(new Point(2,3));
        accessiblePoints.add(new Point(3,3));

        assertThat("List equality without order",
                Fifteen.getAccessiblePoints(new Goblin(new Point(1,1)), Thirteen.readInput(input_flood, 9,9)),
                containsInAnyOrder(accessiblePoints.toArray()));
                containsInAnyOrder(accessiblePoints.toArray());
    }

    @Test
    public void testFindReachableTargets(){

        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 5));
        pointList.add(new Point(7, 5));
        pointList.add(new Point(1, 6));
        pointList.add(new Point(2, 7));
        pointList.add(new Point(7, 6));
        pointList.add(new Point(6, 7));

        assertEquals(pointList, Fifteen.findReachableTargets(
                new Elf(new Point(4,4)),
                Fifteen.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                Thirteen.readInput(input_flood, 9, 9)));

        assertEquals(new ArrayList<>(), Fifteen.findReachableTargets(
                new Goblin(new Point(1,1)),
                Fifteen.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                Thirteen.readInput(input_flood, 9, 9)));
    }

    @Test
    public void testGetManhattanDistance() {
        assertEquals(5, Fifteen.getManhattanDistance(new Point(1, 1), new Point(3, 4)));
        assertEquals(4, Fifteen.getManhattanDistance(new Point(-1, -1), new Point(1, 1)));
    }

    @Test
    public void testGetClosestTargetInReadingOrder() {
        Unit e1 = new Elf(new Point(4,4));
        assertEquals(new Point(1, 5), Fifteen.getClosestTargetInReadingOrder(e1,
                Fifteen.findReachableTargets(e1,
                        Fifteen.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                        Thirteen.readInput(input_flood, 9, 9)))
        );

        Unit e2 = new Elf(new Point(4,7));
        assertEquals(new Point(2, 7), Fifteen.getClosestTargetInReadingOrder(e2,
                Fifteen.findReachableTargets(e2,
                        Fifteen.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                        Thirteen.readInput(input_flood, 9, 9)))
        );

        Unit e3 = new Elf(new Point(4,4));
        assertEquals(new Point(4, 2), Fifteen.getClosestTargetInReadingOrder(e3,
                Fifteen.findReachableTargets(e3,
                        Fifteen.getInitialUnitPositions(Thirteen.readInput(input1, 9, 9)),
                        Thirteen.readInput(input1, 9, 9)))
        );

        Unit g1 = new Goblin(new Point(1,1));
        assertEquals(new Point(4,3), Fifteen.getClosestTargetInReadingOrder(g1,
                Fifteen.findReachableTargets(g1,
                        Fifteen.getInitialUnitPositions(Thirteen.readInput(input1, 9, 9)),
                        Thirteen.readInput(input1, 9, 9)))
        );
    }

    @Test
    public void testGetNextPositionInReadingOrder() {
        Unit e1 = new Elf(new Point(4,4));
        Unit e2 = new Elf(new Point(4,7));
        assertEquals(new Point(4,5), Fifteen.getNextPositionInReadingOrder(e1, new Point(1, 4), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(4,5), Fifteen.getNextPositionInReadingOrder(e1, new Point(7, 4), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(3,7), Fifteen.getNextPositionInReadingOrder(e2, new Point(2, 7), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(4,6), Fifteen.getNextPositionInReadingOrder(e2, new Point(4, 5), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(5,7), Fifteen.getNextPositionInReadingOrder(e2, new Point(6, 7), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(4,6), Fifteen.getNextPositionInReadingOrder(e2, new Point(1, 6), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(4,6), Fifteen.getNextPositionInReadingOrder(e2, new Point(7, 6), Thirteen.readInput(input_flood, 9,9)));

        Unit g1 = new Goblin(new Point(1, 7));
        assertEquals(new Point(2,7), Fifteen.getNextPositionInReadingOrder(g1, new Point(4, 7), Thirteen.readInput(input_flood, 9,9)));
        assertEquals(new Point(1,6), Fifteen.getNextPositionInReadingOrder(g1, new Point(5, 6), Thirteen.readInput(input_flood, 9,9)));
    }
}