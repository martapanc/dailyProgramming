package AoC2018.seventeen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Seventeen {

    static Set<Point> readInput(String inputFile) {

        Set<Point> coordinates = new HashSet<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                coordinates.addAll(processLine(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return coordinates;
    }

    static void drawMatrix(Set<Point> coordinates) {
        int maxX = getMaxCoordinates(coordinates).x;
        int maxY = getMaxCoordinates(coordinates).y + 1;

        printXNumbers(maxX);

        char[][] matrix = new char[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            System.out.printf("%4d ", y);
            for (int x = 0; x < maxX; x++) {

                matrix[y][x] = '.';
                if (x == 500 && y == 0) {
                    matrix[y][x] = '+';
                }
                if (coordinates.contains(new Point(x, y))) {
                    matrix[y][x] = '#';
                }
                System.out.print(matrix[y][x]);
            }
            System.out.print(" " + y + "\n");
        }

        printXNumbers(maxX);
    }

    private static void printXNumbers(int maxX) {
        int u = 1, d = 0, h = 0;
        System.out.println();
        System.out.print("     ");
        for (int x = 1; x <= maxX; x++) {
            System.out.print(h);
            if (x % 100 == 99) {
                h += 1;
            }
        }
        System.out.print("\n     ");
        for (int x = 1; x <= maxX; x++) {
            System.out.print(d);
            if (x % 10 == 9) {
                d += 1;
            }
            if (d % 10 == 0) {
                d = 0;
            }
        }
        System.out.print("\n     ");
        for (int x = 1; x <= maxX; x++) {
            System.out.print(u);
            u += 1;
            if (u % 10 == 0) {
                u = 0;
            }
        }
        System.out.println();
    }

    public static Point getMaxCoordinates(Set<Point> coordinates) {
        int maxX = 0;
        int maxY = 0;
        for (Point p : coordinates) {
            if (p.x > maxX) maxX = p.x;
            if (p.y > maxY) maxY = p.y;
        }
        return new Point(maxX, maxY);
    }

    private static List<Point> processLine(String line) {
        List<Point> points = new ArrayList<>();

        String[] coor = line.split(", ");

        boolean xFirst = coor[0].charAt(0) == 'x';

        if (xFirst) {
            int x = Integer.parseInt(coor[0].replace("x=", ""));
            String y = coor[1].replace("y=", "").replace("..", " ");
            String[] yStr = y.split(" ");
            for (int i = Integer.parseInt(yStr[0]); i <= Integer.parseInt(yStr[1]); i++) {
                points.add(new Point(x, i));
            }
        } else {
            int y = Integer.parseInt(coor[0].replace("y=", ""));
            String x = coor[1].replace("x=", "").replace("..", " ");
            String[] xNum = x.split(" ");
            for (int i = Integer.parseInt(xNum[0]); i <= Integer.parseInt(xNum[1]); i++) {
                points.add(new Point(i, y));
            }
        }

        return points;
    }
}
