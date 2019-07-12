package AoC2018.seventeen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
