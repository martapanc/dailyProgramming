package AoC2019.thirteen;

import AoC2019.nine.Output;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static AoC2019.nine.Nine.processParameterMode;

public class Thirteen {

    static Map<Point, Tile> processInput(ArrayList<Long> numbers) {

        Map<Point, Tile> tileMap = new HashMap<>();
        int i = 0;
        int relativeBase = 0;
        StringBuilder outputBuilder = new StringBuilder();

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }

            Output output = processParameterMode(numbers, i, opCode, 0, relativeBase);
            if (!output.getCode().equals("")) {
                outputBuilder.append(output.getCode()).append(",");
            }

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }
            i += output.getIndex();
        }

        String[] outputs = outputBuilder.toString().split(",");

        for (i = 0; i < outputs.length; i += 3) {
            int x = Integer.parseInt(outputs[i]);
            int y = Integer.parseInt(outputs[i + 1]);
            int tileId = Integer.parseInt(outputs[i + 2]);
            tileMap.put(new Point(x, y), Tile.valueOf(tileId));
        }

        return tileMap;
    }

    static int countTilesOfType(Tile tileType, Map<Point, Tile> processInput) {
        return (int) processInput.values().stream().filter(tile -> tile.equals(tileType)).count();
    }
}
