package AoC2018.thirteen;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThirteenTest {

    private final String input1 = "src/test/java/AoC2018/thirteen/input1";
    private final String input2 = "src/test/java/AoC2018/thirteen/input2";

    private final int ONE_X = 13;
    private final int ONE_Y = 6;
    private final int TWO_XY = 150;

    @Test
    void readInput() {
        Thirteen.readInput(input1, ONE_X, ONE_Y);
        Thirteen.readInput(input2, TWO_XY, TWO_XY);

        Thirteen.printMatrix(Thirteen.readInput(input1, ONE_X, ONE_Y));
        Thirteen.printMatrix(Thirteen.readInput(input2, TWO_XY, TWO_XY));
    }

    @Test
    void findInitialPositions() {
        List<Point> l1 = new ArrayList<>();
        l1.add(new Point(2, 0));
        l1.add(new Point(9, 3));
        assertEquals(l1, Thirteen.findInitialPositions(input1, ONE_X, ONE_Y));

        List<Point> l2 = new ArrayList<>();
        l2.add(new Point(43, 14));
        l2.add(new Point(47, 16));
        assertEquals(l2, Thirteen.findInitialPositions(input2, TWO_XY, TWO_XY));
    }
}