package six;

import org.junit.Test;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SixTest {

    @Test
    public void test_manhattan_distance() {
        assertEquals(4, Six.getManhattanDistance(new Point(0,0), new Point(3,1)));
        assertEquals(7, Six.getManhattanDistance(new Point(0,0), new Point(3,4)));
        assertEquals(7, Six.getManhattanDistance(new Point(3,4), new Point(0,0)));
        assertEquals(5, Six.getManhattanDistance(new Point(3,1), new Point(0,3)));
        assertEquals(0, Six.getManhattanDistance(new Point(3,1), new Point(3,1)));
        assertEquals(1, Six.getManhattanDistance(new Point(0,0), new Point(0,1)));
        assertEquals(2, Six.getManhattanDistance(new Point(0,0), new Point(1,1)));
    }

    @Test
    public void test_get_closest_point(){
        ArrayList<Point> coordinateList = new ArrayList();
        coordinateList.add(new Point(3,1));
        coordinateList.add(new Point(3,4));

        ArrayList<Point> minimumList = new ArrayList<>();
        minimumList.add(new Point(3,1));

        assertEquals(minimumList, Six.getClosestPoint(new Point(0,0), coordinateList));
    }

    @Test
    public void test_get_closest_point_2(){
        ArrayList<Point> coordinateList = new ArrayList();
        coordinateList.add(new Point(3,1));
        coordinateList.add(new Point(1,3));

        ArrayList<Point> minimumList = new ArrayList<>();
        minimumList.add(new Point(3,1));
        minimumList.add(new Point(1,3));

        assertEquals(minimumList, Six.getClosestPoint(new Point(0,0), coordinateList));
    }
}