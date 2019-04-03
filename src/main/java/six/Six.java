package six;

import java.awt.*;
import java.util.*;

public class Six {

    public static int getManhattanDistance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public static ArrayList<Point> getClosestPoint(Point point, ArrayList<Point> coordinateList) {

        Map<Point, Integer> map = new HashMap<>();
        for (Point p : coordinateList)
            map.put(p, getManhattanDistance(point, p));

        Integer min = Collections.min(map.values());
        ArrayList<Point> minimumList = new ArrayList<>();

        for (Map.Entry<Point, Integer> entry : map.entrySet())
            if (Objects.equals(entry.getValue(), min))
                minimumList.add(entry.getKey());

        return minimumList;
    }
}
