package AoC2019.seventeen;

import AoC2019.nine.Output;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static AoC2019.nine.Nine.processParameterMode;

public class Seventeen {

    static Map<Point, String> processInput(ArrayList<Long> numbers, int input) {
        int i = 0;
        int relativeBase = 0;
        Map<Point, String> map = new HashMap<>();
        int x = 1, y = 1;

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }
            Output output = processParameterMode(numbers, i, opCode, input, relativeBase);

            if (output.getCode().length() > 0) {
                switch (output.getCode()) {
                    case "35":
                        map.put(new Point(x++, y), "#");
                        break;
                    case "46":
                        map.put(new Point(x++, y), ".");
                        break;
                    case "10":
                        x = 1;
                        y++;
                }
            }

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }

            i += output.getIndex();
        }
        return map;
    }

    static void printMap(Map<Point, String> map) {
        int maxX = map.keySet().stream().mapToInt(p -> p.x).max().orElse(-1);
        int maxY = map.keySet().stream().mapToInt(p -> p.y).max().orElse(-1);

        for (int y = 1; y <= maxY; y++) {
            for (int x = 1; x <= maxX; x++) {
                String p = map.get(new Point(x, y));
                System.out.print(p != null ? p : " ");
            }
            System.out.println();
        }
    }
}
