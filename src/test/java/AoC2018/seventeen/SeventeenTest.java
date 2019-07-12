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
}