package AoC2019.ten;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ten {

    public static List<SpacePoint> readInput(String input) {

        List<SpacePoint> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            int y = 0;
            while (line != null) {
                int x = 0;
                char[] lineContent = line.trim().toCharArray();
                for (char c : lineContent) {
                    list.add(new SpacePoint(new Point(x++, y), SpaceItem.getSpaceItemFromId(c)));
                }
                line = reader.readLine();
                y++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static boolean arePointsAlignedWithOrigin(SpacePoint origin, SpacePoint p1, SpacePoint p2) {
        return p1.getCoordinate().x == p2.getCoordinate().x ||
                p1.getCoordinate().y == p2.getCoordinate().y;
    }

    static String getLineEquationFromTwoPoints(Point p1, Point p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        if (p1.equals(p2)) {
            return "The points overlap";
        }

        if (y1 == y2) {
            return "y = " + y1;
        }

        if (x1 == x2) {
            return  "x = " + x1;
        }

        double angularCoefficient = (y2 - y1) / (x2 - x1);
        double constant = (x2 * y1 - x1 * y2) / (x2 - x1);


        return "y = " + angularCoefficient + "x" + (constant != 0 ? " + " + constant : "");
    }
}
