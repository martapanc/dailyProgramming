package AoC2019.ten;

import java.awt.Point;
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


}
