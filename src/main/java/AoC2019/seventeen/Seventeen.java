package AoC2019.seventeen;

import AoC2019.nine.Output;

import java.util.ArrayList;

import static AoC2019.nine.Nine.processParameterMode;

public class Seventeen {

    static long processInput(ArrayList<Long> numbers, int input) {
        int i = 0;
        int relativeBase = 0;

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }

            Output output = processParameterMode(numbers, i, opCode, input, relativeBase);

            if (output.getCode().length() > 0) {
                switch (output.getCode()) {
                    case "35":
                        System.out.print("#");
                        break;
                    case "46":
                        System.out.print(".");
                        break;
                    case "10":
                        System.out.println();
                }
            }

            if (output.getRelativeBase() != 0) {
                relativeBase = output.getRelativeBase();
            }

            i += output.getIndex();
        }

        return 0;
    }
}
