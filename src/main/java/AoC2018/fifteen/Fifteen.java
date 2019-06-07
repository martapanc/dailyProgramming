package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static void moveEverything(List<Unit> unitList, char[][] matrix, int turns) {

        int times = 0;
        while (times < turns) {
            System.out.println(" *** Round " + (times + 1) + " ***");
            List<Unit> movingUnits = new ArrayList<>(unitList);
            for (Unit unit : unitList) {
                if (!canUnitAttack(unit, unitList))
                    move(unit, movingUnits, matrix);

                if (canUnitAttack(unit, movingUnits)) {
                    attack(unit, movingUnits, matrix);
                }
            }
            // Sort cursor list by y and then by x (increasing)
            unitList = movingUnits.stream().sorted(Comparator
                    .comparing((Unit u) -> u.position.y)
                    .thenComparing((Unit u) -> u.position.x)
            ).collect(Collectors.toList());

            Thirteen.printMatrix(matrix);
            System.out.println(unitList);

            times += 1;
        }
    }

    public static void attack(Unit playingUnit, List<Unit> unitList, char[][] matrix){
        Point currPos = playingUnit.position;
        Point[] directionArray = getAdjacentPoints(currPos);

        Class targetType = playingUnit instanceof Elf ? Goblin.class : Elf.class;

        List<Unit> enemies = unitList.stream().filter(targetType::isInstance).collect(Collectors.toList());
        List<Unit> adjacentEnemies = new ArrayList<>();
        enemies.forEach(enemy -> Arrays.stream(directionArray).filter(p -> p.equals(enemy.position)).map(p -> enemy).forEach(adjacentEnemies::add));

        Unit attackedEnemy;
        if (adjacentEnemies.size() == 1) {
            attackedEnemy = adjacentEnemies.get(0);
        } else {
            List<Unit> sortedAdjacentEnemies = adjacentEnemies.stream().sorted(Comparator
                    .comparing(Unit::getHitPoints)
                    .thenComparing((Unit u) -> u.position.y)
                    .thenComparing((Unit u) -> u.position.x)
            ).collect(Collectors.toList());
            attackedEnemy = sortedAdjacentEnemies.get(0);
        }

        attackedEnemy.setHitPoints(attackedEnemy.getHitPoints() - playingUnit.getAttackPoints());
        if (attackedEnemy.getHitPoints() <= 0) {
            unitList.remove(attackedEnemy);
            matrix[attackedEnemy.position.y][attackedEnemy.position.x] = '.';
        }
    }

    public static void move(Unit playingUnit, List<Unit> unitList, char[][] matrix) {
        // Get list of enemies that can be reached
        List<Point> reachableTargets = findReachableTargets(playingUnit, unitList, matrix);
        // Get cell next to targets with shortest distance.
        // If no such cell is found (i.e. all four cells around target are occupied, skip moving turn
        Point closestTargetCell = getClosestTargetInReadingOrder(playingUnit, reachableTargets);
        if (!closestTargetCell.equals(new Point(-1,-1))) { // case when unit cannot find any cell in range of a target
            Point nextPosition = getNextPositionInReadingOrder(playingUnit, closestTargetCell, matrix);
            matrix[playingUnit.position.y][playingUnit.position.x] = '.';
            matrix[nextPosition.y][nextPosition.x] = playingUnit.getIdChar();

            for (Unit u : unitList) {
                if (u.position.equals(playingUnit.position)) {
                    u.position = nextPosition;
                }
            }
        }
    }

    public static boolean canUnitAttack(Unit playingUnit, List<Unit> unitList) {
        // If a unit has an enemy in any adjacent cell, it can attack without moving
        Point currPos = playingUnit.position;
        Point[] directionArray = getAdjacentPoints(playingUnit.position);
        Class targetType = playingUnit instanceof Elf ? Goblin.class : Elf.class;

        List<Unit> enemies = unitList.stream().filter(targetType::isInstance).collect(Collectors.toList());

        for (Unit enemy : enemies) {
            for (Point adjacentPt: directionArray) {
                if (adjacentPt.equals(enemy.position)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Point[] getAdjacentPoints(Point currPos) {
        return new Point[] {
                    new Point(currPos.x, currPos.y - 1),
                    new Point(currPos.x, currPos.y + 1),
                    new Point(currPos.x + 1, currPos.y),
                    new Point(currPos.x - 1, currPos.y)
            };
    }

    private static Point[] getFreeAdjacentPoints(Point currPos, char[][] matrix) {
        List<Point> freePoints = new ArrayList<>();
        Point[] adjacentPoints = new Point[]{
                    new Point(currPos.x, currPos.y - 1),
                    new Point(currPos.x, currPos.y + 1),
                    new Point(currPos.x + 1, currPos.y),
                    new Point(currPos.x - 1, currPos.y)
        };
        for (Point p : adjacentPoints) {
            if (matrix[p.y][p.x] == '.') {
                freePoints.add(p);
            }
        }

        Point[] points = new Point[freePoints.size()];
        for (int i = 0; i < freePoints.size(); i++) {
            points[i] = freePoints.get(i);
        }
        return points;
    }

    public static List<Point> findPossibleTargets(Unit playingUnit, List<Unit> unitList, char[][] matrix) {
        // Enemies belong to the opposite category (e.g. Elf for Goblin, and vice versa)
        // For each enemy, create a list of the adjacent (four) cells that are free (.)
        List<Point> pointList = new ArrayList<>();
        Class targetType = playingUnit instanceof Elf ? Goblin.class : Elf.class;

        for (Unit potentialTarget : unitList) {
            // Add potential targets of the 'enemy' category
            if (targetType.isInstance(potentialTarget)) {

                Point[] pointArray = getAdjacentPoints(potentialTarget.position);
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

    public static List<Point> getAllAccessibleTargets(Unit playingUnit, char[][] inputMatrix) {
        // Get ALL cells that a playing unit can reach
        int index = 0;
        int maxX = inputMatrix[0].length - 1, maxY = inputMatrix.length - 1;
        int x = playingUnit.position.x, y = playingUnit.position.y;

        char[][] matrix = new char[inputMatrix[0].length][inputMatrix.length];
        IntStream.range(0, matrix.length).forEach(i -> System.arraycopy(inputMatrix[i], 0, matrix[i], 0, matrix[i].length));

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
        // Reachable targets (i.e. cells adjacent to enemies) are the intersection of the set of reachable cells and the set of target cells

        List<Point> possibleTargets = findPossibleTargets(playingUnit, unitPositions, matrix);
        List<Point> allAccessiblePointsFromUnit = getAllAccessibleTargets(playingUnit, matrix);

        List<Point> reachableTargets = new ArrayList<>();
        possibleTargets.forEach(pt -> allAccessiblePointsFromUnit.stream().filter(pt::equals).map(ap -> pt).forEach(reachableTargets::add));

        return reachableTargets;
    }

    public static Point getClosestTargetInReadingOrder(Unit playingUnit, List<Point> reachableTargets) {
        // Among all reachable targets, pick the closest (reading order is the deal breaker)
        Map<Point, Integer> distanceMap = reachableTargets
                .stream()
                .collect(Collectors.toMap(target -> target, target -> getManhattanDistance(playingUnit.position, target), (a, b) -> b));
        if (distanceMap.size() == 0) {
            return new Point(-1, -1);
        }
        int minDistance = Collections.min(distanceMap.values());
        return distanceMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == minDistance)
                .map(Map.Entry::getKey)
                .sorted(pointComparator())
                .collect(Collectors.toList()).get(0);
    }

    public static Point getNextPositionInReadingOrder(Unit playingUnit, Point target, char[][] matrix) {
        // If any cell adjacent to an enemy is free, the unit can move.
        // Next cell is a free cell (.) with the minimum distance to the target cell (adjacent to enemy)
        // If multiple such cells are found, pick the first in reading order (top-down, left-right)
        Point currPos = playingUnit.position;
        Point[] directionArray = getAdjacentPoints(currPos);

        // TODO: fix function that finds path
        Map<Point, Integer> pointAndDistances = Arrays
                .stream(directionArray)
                .filter(p -> matrix[p.y][p.x] == '.')
                .collect(Collectors.toMap(p -> p, p -> getManhattanDistance(p, target), (a, b) -> b));

        int minDistance = Collections.min(pointAndDistances.values());
        return pointAndDistances.entrySet().stream().filter(entry -> entry.getValue() == minDistance)
                .map(Map.Entry::getKey).sorted(pointComparator()).collect(Collectors.toList()).get(0);
    }

    public static int getManhattanDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static Comparator<Point> pointComparator() {
        //Sort points by increasing distance from the top-left corner
        Point p = new Point(0, -1000);
        final Point finalP = new Point(p.x, p.y);
        return (p0, p1) -> {
            double ds0 = p0.distanceSq(finalP);
            double ds1 = p1.distanceSq(finalP);
            return Double.compare(ds0, ds1);
        };
    }

    public static int findMinDistanceWithBFS(Unit playingUnit, Point targetCell, char[][] inputMatrix) {

        char[][] matrix = new char[inputMatrix[0].length][inputMatrix.length];
        IntStream.range(0, matrix.length).forEach(i -> System.arraycopy(inputMatrix[i], 0, matrix[i], 0, matrix[i].length));

        int count = 0;
        int edge = '0';
        Point[] targetAdjacentPoints = getAdjacentPoints(targetCell);
//        Point[] sourceAdjacentPoints = getFreeAdjacentPoints(playingUnit.position, matrix);
        List<Point> edgeList = Arrays.stream(targetAdjacentPoints).filter(p -> matrix[p.y][p.x] == '.').collect(Collectors.toList());
        List<Point> visitedList;
//        List<Point> nextCellsList = new ArrayList<>();

        boolean reachedStart = false;

        while (!reachedStart) {
//            nextCellsList = new ArrayList<>();
            visitedList = new ArrayList<>();
            for (Point p : edgeList) {
                matrix[p.y][p.x] = (char) edge;
                visitedList.add(p);
//                for (Point sap : sourceAdjacentPoints) {
//                    if (p.equals(sap)) {
//                        nextCellsList.add(p);
//                    }
//                }
            }
            Thirteen.printMatrix(matrix);

            edgeList = new ArrayList<>();

            for (Point v : visitedList) {
                targetAdjacentPoints = getAdjacentPoints(v);
                for (Point a : targetAdjacentPoints) {
                    if (!edgeList.contains(a) && matrix[a.y][a.x] == '.') {
                        edgeList.add(a);
                    }

                    if (matrix[a.y][a.x] == playingUnit.getIdChar() && a.equals(playingUnit.position)) {
                        reachedStart = true;
                    }
                }
            }

            if (!reachedStart) {
                count += 1;
                edge += 1;
                if (edge == 58) {
                    edge = '0';
                }
            }
        }
//        return Character.getNumericValue(edge);
        return count;
    }
}
