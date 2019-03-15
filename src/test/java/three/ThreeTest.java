package three;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ThreeTest {

    @Test
    public void test_compute_occupied_inches(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("2,2");
        expCoordinates.add("2,3");
        expCoordinates.add("3,2");
        expCoordinates.add("3,3");
        assertEquals(expCoordinates, Three.computeOccupiedInches(1, 1, 2, 2));
    }

    @Test
    public void test_compute_occupied_inches_2(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("3,4");
        assertEquals(expCoordinates, Three.computeOccupiedInches(2, 3, 1, 1));
    }

    @Test
    public void test_compute_occupied_inches_3(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("2,2");
        assertEquals(expCoordinates, Three.computeOccupiedInches(1, 1, 1, 1));
    }

    @Test
    public void test_compute_occupied_inches_4(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("2,3");
        expCoordinates.add("2,4");
        expCoordinates.add("2,5");
        expCoordinates.add("3,3");
        expCoordinates.add("3,4");
        expCoordinates.add("3,5");
        assertEquals(expCoordinates, Three.computeOccupiedInches(1, 2, 2, 3));
    }

    @Test
    public void test_compute_occupied_inches_5(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("2,4");
        expCoordinates.add("2,5");
        expCoordinates.add("2,6");
        expCoordinates.add("2,7");
        expCoordinates.add("3,4");
        expCoordinates.add("3,5");
        expCoordinates.add("3,6");
        expCoordinates.add("3,7");
        expCoordinates.add("4,4");
        expCoordinates.add("4,5");
        expCoordinates.add("4,6");
        expCoordinates.add("4,7");
        expCoordinates.add("5,4");
        expCoordinates.add("5,5");
        expCoordinates.add("5,6");
        expCoordinates.add("5,7");
        assertEquals(expCoordinates, Three.computeOccupiedInches(1, 3, 4, 4));
    }

    @Test
    public void test_compute_occupied_inches_6(){
        List<String> expCoordinates = new ArrayList<>();
        expCoordinates.add("1,1");
        expCoordinates.add("1,2");
        expCoordinates.add("2,1");
        expCoordinates.add("2,2");
        assertEquals(expCoordinates, Three.computeOccupiedInches(0, 0, 2, 2));
    }

    @Test
    public void test_check_overlapping_coordinates(){
        List<List<String>> coordinatesList = new ArrayList<>();
        coordinatesList.add(Three.computeOccupiedInches(1,3,4,4));
        coordinatesList.add(Three.computeOccupiedInches(3,1,4,4));

        List<String> overlappingCoordinates = new ArrayList<>();
        overlappingCoordinates.add("4,4");
        overlappingCoordinates.add("4,5");
        overlappingCoordinates.add("5,4");
        overlappingCoordinates.add("5,5");
        assertEquals(overlappingCoordinates, Three.computeOverlappingCoordinates(coordinatesList));
    }

    @Test
    public void test_check_number_of_overlapping_coordinates(){
        List<List<String>> coordinatesList = new ArrayList<>();
        coordinatesList.add(Three.computeOccupiedInches(1,3,4,4));
        coordinatesList.add(Three.computeOccupiedInches(3,1,4,4));
        coordinatesList.add(Three.computeOccupiedInches(5,5,2,2));

        assertEquals(4, Three.computeNumberOfOverlappingCoordinates(coordinatesList));
    }
}