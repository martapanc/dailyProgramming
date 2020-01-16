package AoC2019.seventeen;

import AoC2019.nine.Output;

import java.util.ArrayList;

import static AoC2019.nine.Nine.processParameterMode;

public class Seventeen {

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

//            if (output.getCode().length() > 0) {
//                System.out.println(output.getCode());
//            }

            outputBuilder.append(output.getCode());

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }

            i += output.getIndex();
        }

        return Long.parseLong(outputBuilder.substring(0, 10));
    }
}
