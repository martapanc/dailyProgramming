package AoC2019.fifteen;

import AoC2019.nine.Output;

import java.util.ArrayList;

import static AoC2019.nine.Nine.processParameterMode;

public class Fifteen {

    static long processInput(ArrayList<Long> numbers, int input) {
        int i = 0;
        int relativeBase = 0;
        StringBuilder outputBuilder = new StringBuilder();

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }

            Output output = processParameterMode(numbers, i, opCode, input, relativeBase);
            outputBuilder.append(output.getCode());

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }
            if (outputBuilder.length() > 0) {
                break;
            }
            i += output.getIndex();
        }

        return Long.parseLong(outputBuilder.toString());
    }
}
