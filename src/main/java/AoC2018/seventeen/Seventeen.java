package AoC2018.seventeen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seventeen {

    static List<Point> readInput(String inputFile) {

        List<Point> coordinates = new ArrayList<>();
        List<Point> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();

            List<Point> currPoints = processLine(line);

            lines.addAll(currPoints);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
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
            int y = Integer.parseInt(coor[0].replace("y=x", ""));
            String x = coor[1].replace("x=", "");
            String[] xNum = x.split("..");
            for (int i = Integer.parseInt(xNum[0]); i <= Integer.parseInt(xNum[1]); i++) {
                points.add(new Point(i, y));
            }
        }

        return points;
    }
}
