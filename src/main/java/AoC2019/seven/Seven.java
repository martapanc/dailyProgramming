package AoC2019.seven;

import AoC2019.five.Output;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static AoC2019.five.Five.processParameterMode;
import static AoC2019.seven.PermutationUtil.generatePermutations;

// PART 2
// * 3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5
// The instruction should finish after reaching 1005, which goes to 99 only if [28] == 0, otherwise it jumps back to 3,27
// The input the latter should receive, after the initial 0, must come from the previous amplifier (e.g. E -> A)
// The input that the current amplifier passes to the following one is after 4 ([27] in this case)
// The amplifier's index should be saved so that the process can be continued after the end of the loop (e.g. 1001,28)
// Eventually, the loop should halt

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

    static int findBestResult(ArrayList<Integer> numbers, String phaseSettings) {

        int maxResult = 0;
        for (String phaseSetting : generatePermutations(phaseSettings)) {

            int[] phaseSettingsArr = new int[phaseSettings.length()];
            IntStream.range(0, phaseSetting.length())
                    .forEach(i -> phaseSettingsArr[i] = Integer.parseInt(String.valueOf(phaseSetting.charAt(i))));

            int result = setupAmplifiers(numbers, phaseSettingsArr);
            if (result > maxResult) {
                maxResult = result;
            }
        }
        return maxResult;
    }

    static int setupAmplifiers(ArrayList<Integer> numbers, int[] phaseSettings) {
        int input = 0;
        for (int phaseSetting : phaseSettings) {
            input = processInput(numbers, phaseSetting, input);
        }
        return input;
    }
}
