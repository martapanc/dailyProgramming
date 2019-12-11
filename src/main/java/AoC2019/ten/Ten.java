package AoC2019.ten;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    static List<SpacePoint> listAsteroids(List<SpacePoint> all) {
        List<SpacePoint> asteroids = new ArrayList<>();
        for (SpacePoint sp : all) {
            if (sp.getSpaceItem() == SpaceItem.ASTEROID) {
                asteroids.add(sp);
            }
        }
        return asteroids;
    }
    static boolean arePointsAlignedWithOrigin(SpacePoint origin, SpacePoint p1, SpacePoint p2) {
        return p1.getCoordinate().x == p2.getCoordinate().x ||
                p1.getCoordinate().y == p2.getCoordinate().y;
    }

    // For each asteroid, find the numbers of unique lines between it and the others (if two other asteroids are aligned, the line is added only once)
    static Map<SpacePoint, Set<Line>> findAsteroids(List<SpacePoint> asteroids) {
        Map<SpacePoint, Set<Line>> lineMap = new HashMap<>();
        Map<SpacePoint, List<SpacePoint>> spacePointListMap = new HashMap<>();
        for (SpacePoint asteroid : asteroids) {
            Set<Line> lineSet = new HashSet<>();
            List<SpacePoint> spacePointList = new ArrayList<>();
            for (SpacePoint other : asteroids) {
                Line lineFromTwoPoints = Line.getLineFromTwoPoints(asteroid.getCoordinate(), other.getCoordinate());
                if (!lineSet.contains(lineFromTwoPoints)) {
                    spacePointList.add(other);
                } else {
                    System.out.println("double");
                }
                if (lineFromTwoPoints != null)
                    lineSet.add(lineFromTwoPoints);
            }
            lineMap.put(asteroid, lineSet);
            spacePointListMap.put(asteroid, spacePointList);
        }
        return lineMap;
    }

    static int findLocationsOfBestAsteroid(Map<SpacePoint, Set<Line>> map) {
        return map.values().stream().mapToInt(Set::size).max().orElse(0);
    }
}
