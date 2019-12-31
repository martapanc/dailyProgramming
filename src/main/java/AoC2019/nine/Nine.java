package AoC2019.nine;

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
    //      value at index (e.g. 3,...,104,0 -> out: 3)
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
            i += output.getIndex();
        }

        return Integer.parseInt(outputBuilder.toString());
    }

    public static Output processParameterMode(ArrayList<Long> numbers, int index, int opCode, int inputValue, int relativeBase) {
        int reducedOpCode = opCode % 100;
        Map<Integer, Integer> parameterModeMap = new HashMap<>();
        parameterModeMap.put(1, (opCode / 100) % 10);
        parameterModeMap.put(2, (opCode / 1000) % 10);
        parameterModeMap.put(3, (opCode / 10000) % 10);

        switch (reducedOpCode) {
            case 1:
            case 2:
                sumAndSubtractParam(numbers, index, reducedOpCode, relativeBase, parameterModeMap);
                return new Output("", 4);
            case 3:
            case 4:
                return inputAndOutputParam(numbers, index, reducedOpCode, relativeBase, parameterModeMap, inputValue);
            case 5:
            case 6:
                return new Output("", jumpIf(numbers, index, reducedOpCode, relativeBase, parameterModeMap));
            case 7:
            case 8:
                lessThanOrEquals(numbers, index, reducedOpCode, relativeBase, parameterModeMap);
                return new Output("", 4);
            case 9:
                return new Output("", 2, updateRelativeBase(numbers, index, relativeBase, parameterModeMap));
            default:
                return new Output("err");
        }
    }

    // IntCodes 1 and 2
    private static void sumAndSubtractParam(ArrayList<Long> numbers, int index, int opCode, int relativeBase, Map<Integer, Integer> map) {
        int input1Pos = getParamMode(1, index, relativeBase, numbers, map);
        int input2Pos = getParamMode(2, index, relativeBase, numbers, map);
        int outputPos = getParamMode(3, index, relativeBase, numbers, map);

        if (opCode == 1) {
            numbers.set(outputPos, numbers.get(input1Pos) + numbers.get(input2Pos));
        } else {
            numbers.set(outputPos, numbers.get(input1Pos) * numbers.get(input2Pos));
        }
    }

    // IntCodes 3 and 4
    private static Output inputAndOutputParam(ArrayList<Long> numbers, int index, int opCode, int relativeBase, Map<Integer, Integer> map, int inputValue) {
        int pos = Math.toIntExact(numbers.get(index + 1));
        int outputPos = getParamMode(1, index, relativeBase, numbers, map);

        if (opCode == 3) {
            numbers.set(pos, getInput(inputValue));
            return new Output("", 2);
        } else {
            return new Output(numbers.get(outputPos) + "", 2);
        }
    }

    // IntCodes 5 and 6
    private static long jumpIf(ArrayList<Long> numbers, int index, int opCode, int relativeBase, Map<Integer, Integer> map) {
        int input1Pos = getParamMode(1, index, relativeBase, numbers, map);
        int input2Pos = getParamMode(2, index, relativeBase, numbers, map);

        if (opCode == 5) {
            if (numbers.get(input1Pos) != 0) {
                return numbers.get(input2Pos) - index;
            }
        } else {
            if (numbers.get(input1Pos) == 0) {
                return numbers.get(input2Pos) - index;
            }
        }

        return 3;
    }

    // IntCodes 7 and 8
    private static void lessThanOrEquals(ArrayList<Long> numbers, int index, int opCode, int relativeBase, Map<Integer, Integer> map) {
        int input1Pos = getParamMode(1, index, relativeBase, numbers, map);
        int input2Pos = getParamMode(2, index, relativeBase, numbers, map);
        int outputPos = getParamMode(3, index, relativeBase, numbers, map);

        if (opCode == 7) {
            numbers.set(outputPos, numbers.get(input1Pos) < numbers.get(input2Pos) ? 1L : 0L);
        } else {
            numbers.set(outputPos, numbers.get(input1Pos).equals(numbers.get(input2Pos)) ? 1L : 0L);
        }
    }

    // IntCode 9
    private static int updateRelativeBase(ArrayList<Long> numbers, int index, int relativeBase, Map<Integer, Integer> map) {
        // IntCode 9 can be in position mode (0) or immediate mode (1)
        int outputPos = map.get(1) == 0 ? Math.toIntExact(numbers.get(index + 1)) : index + 1;
        relativeBase += numbers.get(outputPos);

        return relativeBase;
    }

    private static int getParamMode(int paramNum, int index, int relativeBase, ArrayList<Long> numbers, Map<Integer, Integer> map) {
        int pos = Math.toIntExact(numbers.get(index + paramNum));
        switch (map.get(paramNum)) {
            case 0:
                return pos;
            case 1:
                return index + paramNum;
            default:
                return pos + relativeBase;
        }
    }

    private static long getInput(int input) {
        return input;
    }
}
