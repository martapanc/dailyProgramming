package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FifteenTest {

    private final String input1 = "src/test/java/AoC2018/fifteen/input1";
    private final String input2 = "src/test/java/AoC2018/fifteen/input2";
    private final String input_flood = "src/test/java/AoC2018/fifteen/input_flood";
    private final String input_attackFirst = "src/test/java/AoC2018/fifteen/input_attackFirst";
    private final String input_progress = "src/test/java/AoC2018/fifteen/input_progress";
    private final String input_bfs = "src/test/java/AoC2018/fifteen/input_bfs";
    private final String input28 = "src/test/java/AoC2018/fifteen/input28";

    private final String fight1 = "src/test/java/AoC2018/fifteen/fight1";
    private final String fight2 = "src/test/java/AoC2018/fifteen/fight2";
    private final String fight3 = "src/test/java/AoC2018/fifteen/fight3";

    @Test
    public void testReadInputAndPrintMatrix(){
//        Thirteen.printMatrix(Thirteen.readInput(input1, 9,9));
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

        List<Unit> actual = Utils.getInitialUnitPositions(Thirteen.readInput(input1, 9,9));
        IntStream.range(0, unitList.size()).forEach(i -> assertEquals(unitList.get(i).position, actual.get(i).position));
    }

    @Test
    public void testFindPossibleTargets() {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(4, 3));
        pointList.add(new Point(4, 5));
        pointList.add(new Point(5, 4));
        pointList.add(new Point(3, 4));

        assertEquals(pointList, Fifteen.findPossibleTargets(
                new Goblin(new Point(1,1)),
                Utils.getInitialUnitPositions(Thirteen.readInput(input1, 9, 9)),
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
                Fifteen.getAllAccessibleTargets(new Goblin(new Point(1,1)), Thirteen.readInput(input_flood, 9,9)),
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
                Utils.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                Thirteen.readInput(input_flood, 9, 9)));

        assertEquals(new ArrayList<>(), Fifteen.findReachableTargets(
                new Goblin(new Point(1,1)),
                Utils.getInitialUnitPositions(Thirteen.readInput(input_flood, 9, 9)),
                Thirteen.readInput(input_flood, 9, 9)));
    }

    @Test
    public void testGetClosestTargetInReadingOrder() {
        Unit e1 = new Elf(new Point(4,4));
        Unit e2 = new Elf(new Point(4,7));
        char[][] matrix1 = Thirteen.readInput(input_flood, 9, 9);

        assertEquals(new Point(1, 5), Fifteen.getClosestTargetInReadingOrder(e1,
                Fifteen.findReachableTargets(e1,
                        Utils.getInitialUnitPositions(matrix1),
                        matrix1),
                matrix1)
        );
        assertEquals(new Point(2, 7), Fifteen.getClosestTargetInReadingOrder(e2,
                Fifteen.findReachableTargets(e2,
                        Utils.getInitialUnitPositions(matrix1),
                        matrix1),
                matrix1)
        );

        Unit e3 = new Elf(new Point(4,4));
        Unit g1 = new Goblin(new Point(1,1));
        char[][] matrix2 = Thirteen.readInput(input1, 9, 9);

        assertEquals(new Point(4, 2), Fifteen.getClosestTargetInReadingOrder(e3,
                Fifteen.findReachableTargets(e3,
                        Utils.getInitialUnitPositions(matrix2),
                        matrix2),
                matrix2)
        );
        assertEquals(new Point(4,3), Fifteen.getClosestTargetInReadingOrder(g1,
                Fifteen.findReachableTargets(g1,
                        Utils.getInitialUnitPositions(matrix2),
                        matrix2),
                matrix2)
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

    @Test
    public void moveEverything() {
        char[][] matrix1 = Thirteen.readInput(input1, 9, 9);
        Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix1), matrix1, 4);

        assertEquals(24784, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix1), matrix1, 30));

        char[][] matrix2 = Thirteen.readInput(input_progress, 7, 7);
        assertEquals(27730, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix2), matrix2, 48));

        char[][] matrix3 = Thirteen.readInput(input28, 7, 7);
        Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix3), matrix3, 10);

//        char[][] matrix4 = Thirteen.readInput(fight1, 7, 7);
//        assertEquals(36334, Fifteen.moveEverything(Fifteen.getInitialUnitPositions(matrix4), matrix4, 40));

//        char[][] matrix5 = Thirteen.readInput(fight2, 7, 7);
//        assertEquals(39514, Fifteen.moveEverything(Fifteen.getInitialUnitPositions(matrix5), matrix5, 50));

        char[][] matrix6 = Thirteen.readInput(fight3, 7, 7);
        assertEquals(27755, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix6), matrix6, 40));

        char[][] matrix7 = Thirteen.readInput(input2, 32, 32);
        assertEquals(197538, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix7), matrix7, 1000));
    }

    @Test
    public void canUnitAttackDirectly() {
        Unit e1 = new Elf(new Point(4,3));
        Unit g1 = new Goblin(new Point(4,2));
        assertTrue(Fifteen.canUnitAttack(e1, Utils.getInitialUnitPositions(Thirteen.readInput(input_attackFirst, 9,9))));
        assertTrue(Fifteen.canUnitAttack(g1, Utils.getInitialUnitPositions(Thirteen.readInput(input_attackFirst, 9,9))));
    }

    @Test
    public void testBFS() {
        Unit g1 = new Goblin(new Point(5,1));
        Unit g2 = new Goblin(new Point(5,3));
        Unit g3 = new Goblin(new Point(2,2));
        Unit e1 = new Elf(new Point(5,4));

        char[][] inputMatrix = Thirteen.readInput(input_bfs, 7, 7);

        assertEquals(7, Utils.findMinDistanceWithBFS(g1, e1.position, inputMatrix));
        assertEquals(7, Utils.findMinDistanceWithBFS(e1, g1.position, inputMatrix));
        assertEquals(7, Utils.findMinDistanceWithBFS(g2, e1.position, inputMatrix));
        assertEquals(7, Utils.findMinDistanceWithBFS(e1, g2.position, inputMatrix));
        assertEquals(5, Utils.findMinDistanceWithBFS(g3, e1.position, inputMatrix));
        assertEquals(5, Utils.findMinDistanceWithBFS(e1, g3.position, inputMatrix));

        assertEquals(6, Utils.findMinDistanceWithBFS(g1, new Point(5,5), inputMatrix));
        assertEquals(6, Utils.findMinDistanceWithBFS(g2, new Point(5,5), inputMatrix));
        assertEquals(4, Utils.findMinDistanceWithBFS(g3, new Point(5,5), inputMatrix));

        assertEquals(2, Utils.findMinDistanceWithBFS(g3, new Point(2,4), inputMatrix));

        Unit g4 = new Goblin(new Point(11, 11));
        Unit e2 = new Elf(new Point(19, 26));

        assertEquals(27, Utils.findMinDistanceWithBFS(g4, e2.position, Thirteen.readInput(input2, 32,32)));
        assertEquals(27, Utils.findMinDistanceWithBFS(e2, g4.position, Thirteen.readInput(input2, 32,32)));
    }

    @Test
    public void testGetDistance() {
        char[][] matrix = Thirteen.readInput(input_bfs, 7, 7);

        assertEquals(9, Utils.getDistanceWithBFS(new Point(5,1), new Point(5,4), matrix));
        assertEquals(9, Utils.getDistanceWithBFS(new Point(5,4), new Point(5,1), matrix));
        assertEquals(5, Utils.getDistanceWithBFS(new Point(2,1), new Point(1,5), matrix));
        assertEquals(4, Utils.getDistanceWithBFS(new Point(1,1), new Point(1,5), matrix));
    }
}
