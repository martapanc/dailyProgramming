package AoC2018.fifteen;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Fifteen {

    public static List<Unit> getInitialUnitPositions(char[][] matrix){
        List<Unit> unitList = new ArrayList<>();
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 'G') {
                    unitList.add(new Goblin(new Point(x, y)));
                }
                if (matrix[y][x] == 'E') {
                    unitList.add(new Elf(new Point(x, y)));
                }
            }
        }
        return unitList;
    }

    public static List<Point> findPossibleTargets(Unit playingUnit, List<Unit> unitList, char[][] matrix) {
        List<Point> pointList = new ArrayList<>();
        Class targetType = playingUnit instanceof Elf ? Goblin.class : Elf.class;

        for (Unit potentialTarget : unitList) {
            // Add potential targets of the 'enemy' category
            if (targetType.isInstance(potentialTarget)) {
                Point[] pointArray = new Point[] {
                    new Point(potentialTarget.position.x, potentialTarget.position.y - 1),
                    new Point(potentialTarget.position.x + 1, potentialTarget.position.y),
                    new Point(potentialTarget.position.x, potentialTarget.position.y + 1),
                    new Point(potentialTarget.position.x - 1, potentialTarget.position.y)
                };
                char[] charArray = new char[] {
                        matrix[pointArray[0].y][pointArray[0].x],
                        matrix[pointArray[1].y][pointArray[1].x],
                        matrix[pointArray[2].y][pointArray[2].x],
                        matrix[pointArray[3].y][pointArray[3].x]
                };
                for (int i = 0; i < pointArray.length; i++) {
                    if (!pointList.contains(pointArray[i]) && charArray[i] == '.') {
                        pointList.add(pointArray[i]);
                    }
                }
            }
        }
        return pointList;
    }

    public static List<Point> getAccessiblePoints(Unit playingUnit, char[][] matrix) {
        int index = 0;
        int maxX = matrix[0].length - 1, maxY = matrix.length - 1;
        int x = playingUnit.position.x, y = playingUnit.position.y;
        int[][] stack = new int[(maxX+1)*(maxY+1)][2];
        char fillSymbol = '0', originalSymbol = '.';
        List<Point> filledPoints = new ArrayList<>();

        stack[0][1] = x;
        stack[0][0] = y;
        matrix[y][x] = fillSymbol;

        while (index >= 0){
            x = stack[index][1];
            y = stack[index][0];
            index--;

            if ((x > 0) && (matrix[y][x-1] == originalSymbol)){
                matrix[y][x-1] = fillSymbol;
                filledPoints.add(new Point(x-1, y));
                index++;
                stack[index][1] = x-1;
                stack[index][0] = y;
            }
            if ((x < maxX) && (matrix[y][x+1] == originalSymbol)){
                matrix[y][x+1] = fillSymbol;
                filledPoints.add(new Point(x+1, y));
                index++;
                stack[index][1] = x+1;
                stack[index][0] = y;
            }
            if ((y > 0) && (matrix[y-1][x] == originalSymbol)){
                matrix[y-1][x] = fillSymbol;
                filledPoints.add(new Point(x, y-1));
                index++;
                stack[index][1] = x;
                stack[index][0] = y-1;
            }
            if ((y < maxY) && (matrix[y+1][x] == originalSymbol)){
                matrix[y+1][x] = fillSymbol;
                filledPoints.add(new Point(x, y+1));
                index++;
                stack[index][1] = x;
                stack[index][0] = y+1;
            }
        }
        return filledPoints;
    }

    public static List<Point> findReachableTargets(Unit playingUnit, List<Unit> unitPositions, char[][] matrix) {
        List<Point> possibleTargets = findPossibleTargets(playingUnit, unitPositions, matrix);
        List<Point> allAccessiblePointsFromUnit = getAccessiblePoints(playingUnit, matrix);

        List<Point> reachableTargets = new ArrayList<>();
        // Find possible targets that are reachable
        possibleTargets.forEach(pt -> allAccessiblePointsFromUnit.stream().filter(pt::equals).map(ap -> pt).forEach(reachableTargets::add));

        return reachableTargets;
    }

    public static Point getClosestTargetInReadingOrder(Unit playingUnit, List<Point> reachableTargets) {
        Map<Point, Integer> distanceMap = reachableTargets
                .stream()
                .collect(Collectors.toMap(target -> target, target -> getManhattanDistance(playingUnit.position, target), (a, b) -> b));
        int minDistance = Collections.min(distanceMap.values());
        return distanceMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == minDistance)
                .map(Map.Entry::getKey)
                .sorted(pointComparator())
                .collect(Collectors.toList()).get(0);
    }

    public static Point getNextPosition(Unit playingUnit, Point target) {
        //TODO: compute shortest distance
        int currX = playingUnit.position.x, currY = playingUnit.position.y;
        int newX = (currX == target.x) ? currX : ((currX < target.x) ? (currX + 1) : (currX - 1));
        int newY = (currY == target.y) ? currY : ((currY < target.y) ? (currY + 1) : (currY - 1));

        return new Point(newX, newY);
    }

    public static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static Comparator<Point> pointComparator() {
        Point p = new Point(0, -1000);
        final Point finalP = new Point(p.x, p.y);
        return (p0, p1) -> {
            double ds0 = p0.distanceSq(finalP);
            double ds1 = p1.distanceSq(finalP);
            return Double.compare(ds0, ds1);
        };
    }
}
