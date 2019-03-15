package three;

import java.util.ArrayList;
import java.util.List;

public class Three {

    public static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++)
                System.out.print(matrix[j][i] + " ");
            System.out.println();
        }
    }

    public static List<String> computeOccupiedInches(int xBorder, int yBorder, int length, int height) {
        List<String> coordinates = new ArrayList<>();

        for (int x = xBorder+1; x <= xBorder+length; x++) {
            for (int y = yBorder+1; y <= yBorder+height; y++) {
                coordinates.add(x + "," + y);
            }
        }

        return coordinates;
    }

    public static List<String> computeOverlappingCoordinates(List<List<String>> coordinateLists) {

        List<String> overlappingCoordinates = new ArrayList<>();
        List<String> allCoordinates = new ArrayList<>();

        for (List<String> coordinateList : coordinateLists) {
            for (String coordinate : coordinateList) {

                if (!allCoordinates.contains(coordinate)) {
                    allCoordinates.add(coordinate);
                } else {
                    overlappingCoordinates.add(coordinate);
                }
            }
        }

        return overlappingCoordinates;
    }

    public static int computeNumberOfOverlappingCoordinates(List<List<String>> coordinatesList) {

        return computeOverlappingCoordinates(coordinatesList).size();
    }
}
