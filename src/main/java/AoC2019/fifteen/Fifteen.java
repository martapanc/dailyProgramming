package AoC2019.fifteen;

import AoC2019.nine.Output;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static AoC2019.nine.Nine.processParameterMode;

public class Fifteen {

    // north (1), south (2), west (3), east (4)

    // 0: The repair droid hit a wall. Its position has not changed.
    // 1: moved one step in the requested direction
    // 2: moved one step in the requested direction; new position is the location of the oxygen system.

    static String processInput(ArrayList<Long> numbers, int input) {
        int index = 0;
        int relativeBase = 0;
        Map<Point, Character> map = new HashMap<>();
        StringBuilder outputBuilder = new StringBuilder();

        int k = 1000;
        int i = 0;
        // TODO: enum
        int[] directions = new int[]{1, 4, 2, 3}; // n, e, s, w

        while (k-- > 0) {
            int opCode = Math.toIntExact(numbers.get(index));

            Output output = processParameterMode(numbers, index, opCode, directions[i], relativeBase);
            outputBuilder.append(output.getCode());

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }
            if (outputBuilder.length() == 1) {
                if (outputBuilder.toString().equals("0")) {
                    i = new Random().nextInt(directions.length);
                }
                if (outputBuilder.toString().equals("2")) {
                    System.out.println("Found");
                    break;
                }
                System.out.print(outputBuilder.toString());
                outputBuilder = new StringBuilder();
            }
            index += output.getIndex();


            if (i == 4) {
                i = 0;
            }
        }

        return outputBuilder.toString();
    }
}
