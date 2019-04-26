package AoC2018.six;

import org.junit.Test;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void test_get_closest_point_name(){
        Map<String, Point> coordinateList = new HashMap<>();
        coordinateList.put("1", new Point(3,1));
        coordinateList.put("2", new Point(1,3));

        assertEquals("1", Six.getClosestPointName(new Point(3,2), coordinateList));
        assertEquals("2", Six.getClosestPointName(new Point(1,4), coordinateList));
        assertEquals(".", Six.getClosestPointName(new Point(0,0), coordinateList));
        assertEquals("1", Six.getClosestPointName(new Point(3,1), coordinateList));
        assertEquals("2", Six.getClosestPointName(new Point(1,3), coordinateList));
    }

    @Test
    public void test_read_input_file(){
        Map map = Six.readInputFile("src/main/java/AoC2018/six/in2");
        System.out.println(map);
        map = Six.readInputFile("src/main/java/AoC2018/six/in1");
        System.out.println(map);
    }

    @Test
    public void test_draw_matrix(){
        Map map = Six.readInputFile("src/main/java/AoC2018/six/in1");
        Six.drawMatrix(map);
    }

    @Test
    public void test_get_largest_area(){
        Map map = Six.readInputFile("src/main/java/AoC2018/six/in1");
        assertEquals(4475, Six.drawMatrix(map));

        map = Six.readInputFile("src/main/java/AoC2018/six/in4");
        assertEquals(17, Six.drawMatrix(map));
    }

    @Test
    public void test_get_manhattan_distance_sum() {
        Map map = Six.readInputFile("src/main/java/AoC2018/six/in4");
        assertEquals(30, Six.getManhattanDistanceSum(new Point(4,3), map));
    }

    @Test
    public void test_compute_area() {
        Map map = Six.readInputFile("src/main/java/AoC2018/six/in4");
        assertEquals(16, Six.computeArea(map, 32));
        map = Six.readInputFile("src/main/java/AoC2018/six/in1");
        assertEquals(35237, Six.computeArea(map, 10000));
    }

    @Test
    public void test_fib(){
        assertEquals(1, Six.fib(0));
        assertEquals(1, Six.fib(1));
        assertEquals(2, Six.fib(2));
        assertEquals(3, Six.fib(3));
        assertEquals(5, Six.fib(4));
        assertEquals(8, Six.fib(5));
        assertEquals(13, Six.fib(6));
    }
}