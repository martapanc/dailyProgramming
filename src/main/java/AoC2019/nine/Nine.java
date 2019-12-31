package AoC2019.nine;

import AoC2019.five.Output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Nine {

    // 1: sum values at addresses (1) and (2), stores result at address (3)
    // 2: multiply values at addresses (1) and (2), stores result at address (3)
    // 3: read input and save it at address (1)
    // 4: output value of address (1)
    // 5: (1) != 0 set the pointer to the value of (2)
    // 6: (1) == 0 set the pointer to the value of (2)
    // 7: ((1) < (2) ? store 1 : store 0 ) at value of (3)
    // 8: ((1) == (2) ? store 1 : store 0 ) at value of (3)
    // 9: add the value of (1) to the relative base (starting from 0)

    // 0 = position mode    =   parameter is an address
    // 1 = immediate mode   =   parameter is used immediately
    // 2 = relative mode    =   parameter + relative base is an address

    // Parameters that an instruction writes to will never be in immediate mode.

    // PARAMETER MODE DETAILS:
    // - Immediate mode for 4 (104) should output the value of the parameter (e.g. 104,0 -> out: 0). Otherwise it should output the
    //      value at index 0 (e.g. 3,...,104,0 -> out: 3)
    // - 5,6: 105 - (1) and (2) can be in immediate mode
    // - 7,8: 1107 - only (1) and (2) can be in immediate mode
    // - all IntCodes can be in relative mode except for 9

    // The pointer should increment based on the number of parameters (e.g. 4 for Codes 1 and 2, 2 for Codes 3 and 4),
    // except for 5 and 6 where the pointer is updated as described

    // V3 updates:
    // - addresses can be beyond the initial code, if positive, and their initial parameter(s) is 0
    // - support for large numbers

    public static ArrayList<Long> readInput(String input) {
        ArrayList<Long> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                Arrays.stream(line.split(",")).map(Long::parseLong).forEachOrdered(list::add);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static int processInput(ArrayList<Long> numbers, int input) {
        int i = 0;
        StringBuilder outputBuilder = new StringBuilder();

        while (i < numbers.size()) {
            int opCode = Math.toIntExact(numbers.get(i));
            if (opCode == 99) {
                break;
            }

            Output output = processParameterMode(numbers, i, opCode, input);
            outputBuilder.append(output.getCode());
            i += output.getIndex();
        }

        return Integer.parseInt(outputBuilder.toString());
    }

    public static Output processParameterMode(ArrayList<Long> numbers, int index, int opCode, int inputValue) {
        int reducedOpCode = opCode % 100;
        Map<Integer, Integer> parameterModeMap = new HashMap<>();
        parameterModeMap.put(1, (opCode / 100) % 10);
        parameterModeMap.put(2, (opCode / 1000) % 10);
        parameterModeMap.put(3, (opCode / 10000) % 10);

        int relativeBase = 0;

        switch (reducedOpCode) {
            case 1:
            case 2:
                sumAndSubtractParam(numbers, index, reducedOpCode, parameterModeMap);
                return new Output("", 4);
            case 3:
            case 4:
                return inputAndOutputParam(numbers, index, reducedOpCode, parameterModeMap, inputValue);
            case 5:
            case 6:
                return new Output("", jumpIf(numbers, index, reducedOpCode, parameterModeMap));
            case 7:
            case 8:
                lessThanOrEquals(numbers, index, reducedOpCode, parameterModeMap);
                return new Output("", 4);
            case 9:
                updateRelativeBase(numbers, index, relativeBase, parameterModeMap);
                return new Output("", 2);
            default:
                return new Output("err");
        }
    }

    private static void sumAndSubtractParam(ArrayList<Long> numbers, int index, int opCode, Map<Integer, Integer> map) {
        int input1Code = map.get(1) == 0 ? Math.toIntExact(numbers.get(index + 1)) : index + 1;
        int input2Code = map.get(2) == 0 ? Math.toIntExact(numbers.get(index + 2)) : index + 2;
        int outputCode = map.get(3) == 0 ? Math.toIntExact(numbers.get(index + 3)) : index + 3;

        if (opCode == 1) {
            numbers.set(outputCode, numbers.get(input1Code) + numbers.get(input2Code));
        } else {
            numbers.set(outputCode, numbers.get(input1Code) * numbers.get(input2Code));
        }
    }

    private static Output inputAndOutputParam(ArrayList<Long> numbers, int index, int opCode, Map<Integer, Integer> map, int inputValue) {
        int pos = Math.toIntExact(numbers.get(index + 1));
        if (opCode == 3) {
            numbers.set(pos, getInput(inputValue));
            return new Output("", 2);
        } else {
            return new Output(numbers.get((map.get(1) == 0 ? pos : index + 1)) + "", 2);
        }
    }

    private static long jumpIf(ArrayList<Long> numbers, int index, int opCode, Map<Integer, Integer> map) {
        int input1Code = map.get(1) == 0 ? Math.toIntExact(numbers.get(index + 1)) : index + 1;
        int input2Code = map.get(2) == 0 ? Math.toIntExact(numbers.get(index + 2)) : index + 2;

        if (opCode == 5) {
            if (numbers.get(input1Code) != 0) {
                return numbers.get(input2Code) - index;
            }
        } else {
            if (numbers.get(input1Code) == 0) {
                return numbers.get(input2Code) - index;
            }
        }

        return 3;
    }

    private static void lessThanOrEquals(ArrayList<Long> numbers, int index, int opCode, Map<Integer, Integer> map) {
        int input1Code = map.get(1) == 0 ? Math.toIntExact(numbers.get(index + 1)) : index + 1;
        int input2Code = map.get(2) == 0 ? Math.toIntExact(numbers.get(index + 2)) : index + 2;
        int outputPos = Math.toIntExact(numbers.get(index + 3));

        if (opCode == 7) {
            numbers.set(outputPos, numbers.get(input1Code) < numbers.get(input2Code) ? 1L : 0L);
        } else {
            numbers.set(outputPos, numbers.get(input1Code).equals(numbers.get(input2Code)) ? 1L : 0L);
        }
    }

    private static void updateRelativeBase(ArrayList<Long> numbers, int index, int relativeBase, Map<Integer, Integer> map) {

    }

    private static long getInput(int input) {
        return input;
    }
}
