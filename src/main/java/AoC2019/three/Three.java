package AoC2019.three;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Three {

    public static Paths readInput(String input) {
        Paths paths = new Paths();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));

            paths = new Paths(
                    Arrays.stream(reader.readLine().split(","))
                            .map(s -> new Instruction(Direction.getDirectionFromId(s.substring(0, 1)), Integer.parseInt(s.substring(1))))
                            .collect(Collectors.toList()),
                    Arrays.stream(reader.readLine().split(","))
                            .map(s -> new Instruction(Direction.getDirectionFromId(s.substring(0, 1)), Integer.parseInt(s.substring(1))))
                            .collect(Collectors.toList())
            );
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paths;
    }

    static int getPathCoordinates(Paths paths) {
        Point origin = new Point(0, 0);

        List<Point> coordList1 = getCoordinates(paths.getPaths1(), origin);
        List<Point> coordList2 = getCoordinates(paths.getPaths2(), origin);
        Set<Point> intersections = coordList1.stream().filter(coordList2::contains).collect(Collectors.toSet());

        return Collections.min(intersections.stream().map(p -> Math.abs(p.x) + Math.abs(p.y)).collect(Collectors.toList()));
    }

    private static List<Point> getCoordinates(List<Instruction> one, Point origin) {
        List<Point> coordList = new ArrayList<>();
        for (Instruction instruction : one) {
            Point lastPoint = new Point(origin);
            switch (instruction.getDirection()) {
                case UP:
                    for (int u = origin.y + 1; u <= origin.y + instruction.getValue(); u++) {
                        Point e = new Point(origin.x, u);
                        coordList.add(e);
                        lastPoint = e;
                    }
                    break;
                case DOWN:
                    for (int i = origin.y - 1; i >= origin.y - instruction.getValue(); i--) {
                        Point e1 = new Point(origin.x, i);
                        coordList.add(e1);
                        lastPoint = e1;
                    }
                    break;
                case RIGHT:
                    for (int i = origin.x + 1; i <= origin.x + instruction.getValue(); i++) {
                        Point e2 = new Point(i, origin.y);
                        coordList.add(e2);
                        lastPoint = e2;
                    }
                    break;
                case LEFT:
                    for (int i = origin.x - 1; i >= origin.x - instruction.getValue(); i--) {
                        Point e3 = new Point(i, origin.y);
                        coordList.add(e3);
                        lastPoint = e3;
                    }
                    break;
            }
            origin = new Point(lastPoint);
        }
        return coordList;
    }
}
