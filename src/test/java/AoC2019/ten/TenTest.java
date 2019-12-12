package AoC2019.ten;

import org.junit.Test;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNull;

public class TenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/ten/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/ten/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/ten/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/ten/input4";
    private static final String INPUT5 = "src/test/java/AoC2019/ten/input5";
    private static final String INPUT6 = "src/test/java/AoC2019/ten/input6";
    private static final String INPUT7 = "src/test/java/AoC2019/ten/input7";
    private static final String INPUT8 = "src/test/java/AoC2019/ten/input8";

    @Test
    public void testReadInput() {
        List<SpacePoint> list = Ten.readInput(INPUT1);
        assertEquals(25, list.size());
        System.out.println(list);
    }

    @Test
    public void testListAsteroids() {
        List<SpacePoint> list = Ten.readInput(INPUT1);
        List<SpacePoint> asteroids = Ten.listAsteroids(list);
        assertEquals(25, list.size());
        assertEquals(10, asteroids.size());
        System.out.println(list);
        System.out.println(asteroids);
    }

    @Test
    public void getLineFromTwoPoints() {
        assertEquals(new Line(9999, 4, true, false), Line.getLineFromTwoPoints(new Point(4, 1), new Point(4, 15)));
        assertEquals(new Line(0, 3, false, true), Line.getLineFromTwoPoints(new Point(0, 3), new Point(2, 3)));

        assertEquals(new Line(2, 0), Line.getLineFromTwoPoints(new Point(0, 0), new Point(1, 2)));
        assertEquals(new Line(2, 1), Line.getLineFromTwoPoints(new Point(0, 1), new Point(1, 3)));
        assertEquals(new Line(-1.45, 34.45), Line.getLineFromTwoPoints(new Point(23, 1), new Point(12, 17)));
        assertEquals(new Line(0.18, 0.64), Line.getLineFromTwoPoints(new Point(2, 1), new Point(13, 3)));

        assertNull(Line.getLineFromTwoPoints(new Point(0, 3), new Point(0, 3)));
    }

    @Test
    public void testDoesPointBelongToLine() {
        assertTrue(Line.doesPointBelongToLine(new Point(0, 0), new Line(2, 0)));
        assertTrue(Line.doesPointBelongToLine(new Point(3, 0), new Line(0, 3, true, false)));
        assertTrue(Line.doesPointBelongToLine(new Point(1, 4), new Line(0, 4, false, true)));

        assertFalse(Line.doesPointBelongToLine(new Point(0, 0), new Line(2, 1)));
        assertFalse(Line.doesPointBelongToLine(new Point(4, 1), new Line(0, 3, true, false)));
        assertFalse(Line.doesPointBelongToLine(new Point(1, 3), new Line(0, 4, false, true)));
    }

    @Test
    public void testFindAsteroids() {
        Map<SpacePoint, List<Line>> asteroids = Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT1)));
        System.out.println(asteroids);
        assertEquals(8, Ten.findLocationsOfBestAsteroid(asteroids));

        assertEquals(33, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT2)))));
        assertEquals(16, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT7)))));
        assertEquals(35, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT3)))));
        assertEquals(41, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT4)))));
        assertEquals(210, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT5)))));
        assertEquals(230, Ten.findLocationsOfBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT6)))));
    }

    @Test
    public void testFindBestAsteroids() {
        assertEquals(new SpacePoint(new Point(3,4), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT1)))));
        assertEquals(new SpacePoint(new Point(5,8), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT2)))));
        assertEquals(new SpacePoint(new Point(1,2), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT3)))));
        assertEquals(new SpacePoint(new Point(6,3), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT4)))));
        assertEquals(new SpacePoint(new Point(11,13), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT5)))));
        assertEquals(new SpacePoint(new Point(19,11), SpaceItem.ASTEROID), Ten.findBestAsteroid(Ten.findAsteroids(Ten.listAsteroids(Ten.readInput(INPUT6)))));
    }

    @Test
    public void testGetAngularCoefficientMap() {
        System.out.println(Ten.getAngularCoefficientMap(new Point(19,11), Ten.listAsteroids(Ten.readInput(INPUT6))));
        System.out.println(Ten.getAngularCoefficientMap(new Point(11,13), Ten.listAsteroids(Ten.readInput(INPUT5))));
        System.out.println(Ten.getAngularCoefficientMap(new Point(8,3), Ten.listAsteroids(Ten.readInput(INPUT8))));
        System.out.println(Ten.getAngularCoefficientMap(new Point(3,2), Ten.listAsteroids(Ten.readInput(INPUT1))));
        System.out.println(Ten.getAngularCoefficientMap(new Point(3,4), Ten.listAsteroids(Ten.readInput(INPUT1))));
        System.out.println(Ten.getAngularCoefficientMap(new Point(3,3), Ten.listAsteroids(Ten.readInput(INPUT2))));
    }
}
