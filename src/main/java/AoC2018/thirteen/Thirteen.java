package AoC2018.thirteen;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        Point p1 = points.get(0);
        Point p2 = points.get(1);

        Cursor c1 = new Cursor(Direction.valueOf(matrix[p1.y][p1.x]), p1, Turn.LEFT, '-');
        c1.setTrackCellType(( c1.direction == Direction.NORTH || c1.direction == Direction.SOUTH ? '|' : '-'));

        Cursor c2 = new Cursor(Direction.valueOf(matrix[p2.y][p2.x]), p2, Turn.LEFT, '-');
        c2.setTrackCellType(( c2.direction == Direction.NORTH || c2.direction == Direction.SOUTH ? '|' : '-'));

        while (!c1.currentPos.equals(c2.currentPos)) {
            c1 = getNextCursor(c1, matrix);
            c2 = getNextCursor(c2, matrix);

//            printMatrix(matrix);
        }

        System.out.println("Cursors collided at (" + c1.currentPos.x + ", " + c1.currentPos.y + ")");
        return c1.currentPos;
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

        matrix[c.currentPos.y][c.currentPos.x] = c.trackCellType;
        matrix[c.nextPos.y][c.nextPos.x] = c.direction.getDirChar();
        return new Cursor(c.direction, c.nextPos, nextTurn, nextCell);
    }
}
