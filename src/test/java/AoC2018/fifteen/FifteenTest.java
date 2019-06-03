package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class FifteenTest {

    private final String input1 = "src/test/java/AoC2018/fifteen/input1";

    @Test
    public void testReadInputAndPrintMatrix(){
        Thirteen.printMatrix(Thirteen.readInput(input1, 9,9));
    }

    @Test
    public void fight() {
        Fifteen.fight();
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
}