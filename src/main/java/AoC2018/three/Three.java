package AoC2018.three;

import java.util.ArrayList;
import java.util.List;

public class Three {

    public static Item computeOccupiedInches(int id, int xBorder, int yBorder, int length, int height) {
        List<String> coordinates = new ArrayList<>();

        for (int x = xBorder+1; x <= xBorder+length; x++) {
            for (int y = yBorder+1; y <= yBorder+height; y++) {
                coordinates.add(x + "," + y);
            }
        }

        return new Item(id, coordinates);
    }

    public static List<String> computeOverlappingCoordinates(List<Item> coordinateLists) {

        List<String> overlappingCoordinates = new ArrayList<>();
        List<String> allCoordinates = new ArrayList<>();

        for (Item coordinateList : coordinateLists) {

            for (String coordinate : coordinateList.getCoordinates()) {

                if (!allCoordinates.contains(coordinate)) {
                    allCoordinates.add(coordinate);
                } else {
                    if (!overlappingCoordinates.contains(coordinate)) {
                        overlappingCoordinates.add(coordinate);
                    }
                }
            }
        }

        findCoordinatesThatDontOverLap(coordinateLists, overlappingCoordinates);

        return overlappingCoordinates;
    }

    private static void findCoordinatesThatDontOverLap(List<Item> coordinateLists, List<String> overlappingCoordinates) {
        for (Item coordinateList : coordinateLists) {
            boolean doesntOverlap = true;
            for (String coordinate: coordinateList.getCoordinates()) {
                if (overlappingCoordinates.contains(coordinate)) {
                    doesntOverlap = false;
                }
            }

            if (doesntOverlap) {
                System.out.println("Doesn't overlap: " + coordinateList.getId());
            }
        }
    }

    public static int computeNumberOfOverlappingCoordinates(List<Item> coordinatesList) {

        return computeOverlappingCoordinates(coordinatesList).size();
    }
}
