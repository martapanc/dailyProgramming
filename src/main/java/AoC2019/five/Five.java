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

    // Immediate mode for 4 (104) should output the value of the parameter (e.g. 104,0 -> out: 0)
    // Otherwise it should output the value at index 0 (e.g. 3,...,104,0 -> out: 3)

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
                    outputBuilder.append(processParameterMode(numbers, i, opCode));
                    int lastDigit = opCode % 10;
                    if (lastDigit == 1 || lastDigit == 2) {
                        i += 4;
                    } else {
                        i += 2;
                    }
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

    private static void sumAndSubtractParam(ArrayList<Integer> numbers, int index, int opCode, Map<Integer, Integer> map) {
        Integer input1Pos = numbers.get(index + 1);
        Integer input2Pos = numbers.get(index + 2);
        Integer outputPos = numbers.get(index + 3);
        if (opCode == 1) {
            numbers.set(
                    (map.get(3) == 0 ? outputPos : index + 3),
                    numbers.get((map.get(1) == 0 ? input1Pos : index + 1)) +
                    numbers.get((map.get(2) == 0 ? input2Pos : index + 2)));
        } else {
            numbers.set(
                    (map.get(3) == 0 ? outputPos : index + 3),
                    numbers.get((map.get(1) == 0 ? input1Pos : index + 1)) *
                    numbers.get((map.get(2) == 0 ? input2Pos : index + 2)));
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

    private static String inputAndOutputParam(ArrayList<Integer> numbers, int index, int opCode, Map<Integer, Integer> map) {
        Integer pos = numbers.get(index + 1);
        if (opCode == 3) {
            numbers.set(pos, getInput(1));
            return "";
        } else {
            return numbers.get((map.get(1) == 0 ? pos : index + 1)) + "";
        }
    }

    private static String processParameterMode(ArrayList<Integer> numbers, int index, int opCode) {
        int reducedOpCode = opCode % 100;
        Map<Integer, Integer> parameterModeMap = new HashMap<>();
        parameterModeMap.put(1, (opCode / 100) % 10);
        parameterModeMap.put(2, (opCode / 1000) % 10);
        parameterModeMap.put(3, (opCode / 10000) % 10);

        if (reducedOpCode == 1 || reducedOpCode == 2) {
            sumAndSubtractParam(numbers, index, reducedOpCode, parameterModeMap);
            return "";
        } else {
            return inputAndOutputParam(numbers, index, reducedOpCode, parameterModeMap);
        }
    }

    private static int getInput(int input) {
        return input;
    }
}
