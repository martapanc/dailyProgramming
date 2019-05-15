package AoC2018.ten;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ten {

    static List<MovingPoint> readInput(String inputFile) {
        List<MovingPoint> pointList = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();

            while (line != null) {
                int[] input = Stream.of(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                pointList.add(new MovingPoint(input[0], input[1], input[2], input[3]));
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pointList;
    }

    private static List<Point> getListOfCurrentPoints(List<MovingPoint> movingPoints, int seconds) {

        return movingPoints.stream().map(
                p -> new Point(
                p.getPositionX() + p.getSpeedX() * seconds,
                p.getPositionY() + p.getSpeedY() * seconds)
        ).collect(Collectors.toList());
    }

    static void computeCloseCoordinates(List<MovingPoint> movingPoints, int time) {

        List<Point> points = getListOfCurrentPoints(movingPoints, 0);
        while (Math.abs(points.get(0).x - points.get(1).x) > 80) {
            points = getListOfCurrentPoints(movingPoints, time);
            time += 1;
        }

        System.out.println(time);
        System.out.println(points);
    }

    static void compute(List<MovingPoint> movingPoints, int seconds) {

        List<Point> points = getListOfCurrentPoints(movingPoints, seconds);
        int minX = Objects.requireNonNull(points.stream().min(Comparator.comparing(Point::getX)).orElse(null)).x;
        int minY = Objects.requireNonNull(points.stream().min(Comparator.comparing(Point::getY)).orElse(null)).y;

        points.forEach(p -> p.setLocation(p.getX() - minX, p.getY() - minY));

        int maxX = Objects.requireNonNull(points.stream().max(Comparator.comparing(Point::getX)).orElse(null)).x + 1;
        int maxY = Objects.requireNonNull(points.stream().max(Comparator.comparing(Point::getY)).orElse(null)).y + 1;

        String[][] matrix = new String[maxY][maxX];
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                matrix[y][x] = ".";
            }
        }

        points.forEach(p -> matrix[p.y][p.x] = "#");

        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                System.out.print(matrix[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
