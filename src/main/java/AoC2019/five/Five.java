package AoC2019.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Five {

    // 1: sum values at addresses (1) and (2), stores result at address (3)
    // 2: multiply values at addresses (1) and (2), stores result at address (3)
    // 3: read input and save it at address (1)
    // 4: output value of address (1)

    // 0 = position mode
    // 1 = immediate mode
    // Parameters that an instruction writes to will never be in immediate mode.

    // The pointer should increment based on the number of parameters (e.g. 4 for Codes 1 and 2, 2 for Codes 3 and 4)

    static int processInput(ArrayList<Integer> numbers) {

        int i = 0;
        StringBuilder outputBuilder = new StringBuilder();

        while (i < numbers.size()) {
            int opCode = numbers.get(i);
            if (opCode == 99) {
                break;
            }

            switch (opCode) {
                case 1:
                case 2:
                    sumAndSubtract(numbers, i, opCode);
                    i += 4;
                    break;
                case 3:
                case 4:
                    outputBuilder.append(inputAndOutput(numbers, i, opCode));
                    i += 2;
                    break;
                default:
                    processParameterMode(opCode);
            }
        }

        return Integer.parseInt(outputBuilder.toString());
    }

    private static void sumAndSubtract(ArrayList<Integer> numbers, int index, int opCode) {
        Integer input1Pos = numbers.get(index + 1);
        Integer input2Pos = numbers.get(index + 2);
        Integer outputPos = numbers.get(index + 3);
        if (opCode == 1) {
            numbers.set(outputPos, numbers.get(input1Pos) + numbers.get(input2Pos));
        } else {
            numbers.set(outputPos, numbers.get(input1Pos) * numbers.get(input2Pos));
        }
    }

    private static String inputAndOutput(ArrayList<Integer> numbers, int index, int opCode) {
        Integer pos = numbers.get(index + 1);
        if (opCode == 3) {
            numbers.set(pos, getInput(1));
            return "";
        } else {
            return numbers.get(pos) + "";
        }
    }

    private static void processParameterMode(int input) {
        int opCode = input % 100;
        Map<Integer, Integer> parameterModeMap = new HashMap<>();
        parameterModeMap.put(1, (input / 100) % 10);
        parameterModeMap.put(2, (input / 1000) % 10);
        parameterModeMap.put(3, (input / 10000) % 10);
    }
    private static int getInput(int input) {
        return input;
    }
}
