package AoC2018.thirteen;

import org.testng.internal.thread.DefaultThreadPoolExecutorFactory;

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
                if (points.size() == 2)
                    break;
            }
            if (points.size() == 2)
                break;
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
        System.out.println();
    }

    public static void moveCursor(char[][] matrix, List<Point> points) {


//        while (!points.get(0).equals(points.get(1))) {
//
//
//        }

        for (Point p : points) {
            Cursor c = new Cursor(Direction.valueOf(matrix[p.y][p.x]), p, Turn.LEFT, '-');
            c.setTrackCellType(( c.direction == Direction.NORTH || c.direction == Direction.SOUTH ? '|' : '-'));

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

            Cursor next_c = new Cursor(c.direction, c.nextPos, Turn.LEFT, nextCell);

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
                c.nextTurn = Turn.valueOf((c.nextTurn.getTurnVal() + 1) % 3);
            }

            System.out.println();
        }

    }
}
