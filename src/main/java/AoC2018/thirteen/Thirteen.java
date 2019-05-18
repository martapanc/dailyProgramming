package AoC2018.thirteen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Thirteen {

    static char[][] readInput(String inputFile, int horLength, int verLength) {

        char[][] input = new char[verLength][horLength];

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            int yCoor = 0;

            String line = reader.readLine();

            while (yCoor < verLength) {

                char[] arr = line.toCharArray();
                for (int i = 0; i < input[yCoor].length; i++) {
                    input[yCoor][i] = i < arr.length ? arr[i] : ' ';
                }
                line = reader.readLine();
                yCoor += 1;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }

    public static List<Point> findInitialPositions(String inputFile, int horLength, int verLength) {

        List<Point> points = new ArrayList<>();
        char[][] matrix = readInput(inputFile, horLength, verLength);

        for (int y = 0; y < verLength; y++) {
            for (int x = 0; x < horLength; x++) {
                if (matrix[y][x] == '^' || matrix[y][x] == '>' || matrix[y][x] == 'v' || matrix[y][x] == '<') {
                    points.add(new Point(x, y));
                }
            }
        }

        return points;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] yChars : matrix) {
            for (char xChar : yChars) {
                System.out.print(xChar);
            }
            System.out.println();
        }
    }

    public static Point findFirstCollisionPoint(char[][] matrix, List<Point> points) {

        List<Cursor> cursorList = new ArrayList<>();
        for (Point p : points) {
            Cursor c1 = new Cursor(Direction.valueOf(matrix[p.y][p.x]), p, Turn.LEFT, '-');
            c1.setTrackCellType(( c1.direction == Direction.NORTH || c1.direction == Direction.SOUTH ? '|' : '-'));

            cursorList.add(c1);
        }

        while (areAllUnique(cursorList)) {
            cursorList = cursorList.stream().sorted(Comparator
                    .comparing((Cursor c) -> c.currentPos.y)
                    .thenComparing((Cursor c) -> c.currentPos.x)
            ).collect(Collectors.toList());

            List<Cursor> newCursorList = new ArrayList<>();
            cursorList.forEach(c -> newCursorList.add(c));

            for (Cursor c : cursorList) {

                Cursor newCur = getNextCursor(c, matrix);
                if (newCur.nextTurn == null) {

                    Cursor nextC = newCursorList.stream()
                            .filter(k -> k.currentPos.equals(newCur.nextPos))
                            .collect(Collectors.toList()).get(0);
                    matrix[nextC.currentPos.y][nextC.currentPos.x] = nextC.trackCellType;
                    return newCur.nextPos;
                }
                newCursorList.remove(c);
                newCursorList.add(newCur);
            }
            cursorList = newCursorList;
        }
        return null;
    }

    public static boolean areAllUnique(List<Cursor> list){
        Set<Point> set = new HashSet<>();
        for (Cursor t: list){
            if (!set.add(t.currentPos))
                return false;
        }
        return true;
    }

    public static Cursor getNextCursor(Cursor c, char[][] matrix) {

        Turn nextTurn = c.nextTurn;

        // Handle cursor turn if the current cell is a +
        if (c.trackCellType == '+') {
            switch (c.nextTurn) {
                case LEFT:
                    switch (c.direction.getDirChar()) {
                        case '^':
                            c.direction = Direction.valueOf('<');
                            break;
                        case '>':
                            c.direction = Direction.valueOf('^');
                            break;
                        case 'v':
                            c.direction = Direction.valueOf('>');
                            break;
                        case '<':
                            c.direction = Direction.valueOf('v');
                            break;
                    }
                    break;

                case RIGHT:
                    switch (c.direction.getDirChar()) {
                        case '^':
                            c.direction = Direction.valueOf('>');
                            break;
                        case '>':
                            c.direction = Direction.valueOf('v');
                            break;
                        case 'v':
                            c.direction = Direction.valueOf('<');
                            break;
                        case '<':
                            c.direction = Direction.valueOf('^');
                            break;
                    }
                    break;
            }

            nextTurn = Turn.valueOf((c.nextTurn.getTurnVal() + 1) % 3);
        }

        // Handle cursor turn if the current cell is a turn ◜◝◞◟
        switch (c.trackCellType) {
            case '◜':
                if (c.direction == Direction.NORTH) {
                    c.direction = Direction.valueOf('>');
                } else {
                    c.direction = Direction.valueOf('v');
                }
                break;
            case '◝':
                if (c.direction == Direction.NORTH) {
                    c.direction = Direction.valueOf('<');
                } else {
                    c.direction = Direction.valueOf('v');
                }
                break;
            case '◞':
                if (c.direction == Direction.SOUTH) {
                    c.direction = Direction.valueOf('<');
                } else {
                    c.direction = Direction.valueOf('^');
                }
                break;
            case '◟':
                if (c.direction == Direction.SOUTH) {
                    c.direction = Direction.valueOf('>');
                } else {
                    c.direction = Direction.valueOf('^');
                }
                break;
        }

        // Get coordinates of next cell
        switch (c.direction) {
            case NORTH:
                c.setNextPos(new Point(c.currentPos.x, c.currentPos.y - 1));
                break;
            case SOUTH:
                c.setNextPos(new Point(c.currentPos.x, c.currentPos.y + 1));
                break;
            case EAST:
                c.setNextPos(new Point(c.currentPos.x + 1, c.currentPos.y));
                break;
            case WEST:
                c.setNextPos(new Point(c.currentPos.x - 1, c.currentPos.y));
                break;
        }

        // Get type of next cell
        char nextCell = matrix[c.nextPos.y][c.nextPos.x];

        if (nextCell == '>' || nextCell == 'v' || nextCell == '<' || nextCell == '^') {
            matrix[c.currentPos.y][c.currentPos.x] = c.trackCellType;
            Cursor currC = new Cursor(c.direction, c.currentPos, null, c.trackCellType);
            currC.setNextPos(c.nextPos);
            return currC;
        }

        matrix[c.currentPos.y][c.currentPos.x] = c.trackCellType;
        matrix[c.nextPos.y][c.nextPos.x] = c.direction.getDirChar();
        return new Cursor(c.direction, c.nextPos, nextTurn, nextCell);
    }
}
