package AoC2019.fifteen;

import AoC2019.nine.Output;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static AoC2019.nine.Nine.processParameterMode;

public class Fifteen {

    static String processInput(ArrayList<Long> numbers, int input) {
        int index = 0;
        int relativeBase = 0;

        Point currentPoint = new Point(0, 0);
        Map<Point, Cell> map = new HashMap<>();
        map.put(currentPoint, new Cell(CellType.PATH));
        StringBuilder outputBuilder = new StringBuilder();

        int k = 10000;
        Direction direction = Direction.EAST;

        loop: while (k-- > 0) {
            int opCode = Math.toIntExact(numbers.get(index));

            Output output = processParameterMode(numbers, index, opCode, direction.getDirectionId(), relativeBase);
            outputBuilder.append(output.getCode());

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }

            if (outputBuilder.length() == 1) {
                Point nextPoint = getNextCellCoordinates(currentPoint, direction);

                switch (outputBuilder.toString()) {
                    case "0":
                        if (map.get(nextPoint) != null) {
                            map.get(nextPoint).getNotVisited().remove(direction);
                            direction = turnRight(direction);

                        } else {
                            map.put(nextPoint, new Cell(CellType.WALL));
                            map.get(currentPoint).getNotVisited().remove(direction);
                            direction = turnLeft(direction);
//                            direction = Direction.getValueOf(new Random().nextInt(3) + 1);
                        }
                        break;
                    case "1":
                        if (map.get(nextPoint) == null) {
                            map.put(nextPoint, new Cell(CellType.PATH));
                        }

                        map.get(currentPoint).getNotVisited().remove(direction);
                        currentPoint = new Point(nextPoint.x, nextPoint.y);

                        break;
                    case "2":
                        System.out.println("Found");
                        break loop;
                    default:
                        System.out.println("Unexpected output");
                        break loop;
                }

                printCellMap(map);
//                System.out.print(outputBuilder.toString());
                outputBuilder = new StringBuilder();
            }
            index += output.getIndex();
        }

        return outputBuilder.toString();
    }

    private static Direction getRandomNonVisitedDirection(Map<Point, Cell> map, Point point) {
        List<Direction> notVisited = map.get(point).getNotVisited();
        return notVisited.get(new Random().nextInt(notVisited.size()));
    }

    private static Direction turnLeft(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.WEST;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            case EAST:
                return Direction.NORTH;
            default:
                return null;
        }
    }

    private static Direction turnRight(Direction direction) {
        switch (direction) {
            case NORTH:
                return Direction.EAST;
            case EAST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.WEST;
            case WEST:
                return Direction.NORTH;
            default:
                return null;
        }
    }

    static Point getNextCellCoordinates(Point currentCell, Direction direction) {
        switch (direction) {
            case NORTH:
                return new Point(currentCell.x, currentCell.y + 1);
            case EAST:
                return new Point(currentCell.x + 1, currentCell.y);
            case SOUTH:
                return new Point(currentCell.x, currentCell.y - 1);
            case WEST:
                return new Point(currentCell.x - 1, currentCell.y);
        }

        return null;
    }

    static void printCellMap(Map<Point, Cell> cellMap) {
        int minX = cellMap.keySet().stream().mapToInt(p -> p.x).min().orElse(-1);
        int maxX = cellMap.keySet().stream().mapToInt(p -> p.x).max().orElse(-1);
        int minY = cellMap.keySet().stream().mapToInt(p -> p.y).min().orElse(-1);
        int maxY = cellMap.keySet().stream().mapToInt(p -> p.y).max().orElse(-1);

        for (int y = maxY; y >= minY; y--) {
            for (int x = maxX; x >= minX; x--) {
                Point key = new Point(x, y);
                if (cellMap.containsKey(key)) {
                    System.out.print(cellMap.get(key).getType().getSymbol());
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

