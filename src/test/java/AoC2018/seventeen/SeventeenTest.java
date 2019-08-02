package AoC2018.seventeen;

import org.junit.Test;

import java.awt.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class SeventeenTest {

    private final String input1 = "src/test/java/AoC2018/seventeen/input1";
    private final String input2 = "src/test/java/AoC2018/seventeen/input2";
    private final String input3 = "src/test/java/AoC2018/seventeen/input3";

    @Test
    public void test_readInput(){
        Set<Point> points = new HashSet<>();
        points.add(new Point(495, 2));
        points.add(new Point(495, 3));
        points.add(new Point(495, 4));
        points.add(new Point(495, 5));
        assertEquals(points, Seventeen.readInput(input3));

        assertEquals(34, Seventeen.readInput(input2).size());
    }

    @Test
    public void test_maxCoordinates() {
        assertEquals(new Point(564, 1880), Seventeen.getMaxCoordinates(Seventeen.readInput(input1)));
        assertEquals(new Point(506, 13), Seventeen.getMaxCoordinates(Seventeen.readInput(input2)));
        assertEquals(new Point(495, 5), Seventeen.getMaxCoordinates(Seventeen.readInput(input3)));
    }

    @Test
    public void test_drawMatrix(){
        Seventeen.drawMatrix(Seventeen.readInput(input3));
        Seventeen.drawMatrix(Seventeen.readInput(input2));
        Seventeen.drawMatrix(Seventeen.readInput(input1));
    }
}