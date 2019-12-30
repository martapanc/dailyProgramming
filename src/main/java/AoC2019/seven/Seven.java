package AoC2019.seven;

import AoC2019.five.Output;

import java.util.ArrayList;

import static AoC2019.five.Five.processParameterMode;

public class Seven {

    static int processInput(ArrayList<Integer> numbers, int input1, int input2) {
        int i = 0;
        StringBuilder outputBuilder = new StringBuilder();

        boolean firstInputUsed = false;

        while (i < numbers.size()) {
            int opCode = numbers.get(i);
            if (opCode == 99) {
                break;
            }

            int inputValue = input1;
            if (firstInputUsed) {
                inputValue = input2;
            }
            if (opCode == 3) {
                firstInputUsed = true;
            }

            Output output = processParameterMode(numbers, i, opCode, inputValue);
            outputBuilder.append(output.getCode());
            i += output.getIndex();
        }

        return Integer.parseInt(outputBuilder.toString());
    }
}
