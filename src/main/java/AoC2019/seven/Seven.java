package AoC2019.seven;

import AoC2019.five.Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    static int setupAmplifiers(ArrayList<Integer> numbers, int[] phaseSettings){
        int input = 0;
        for (int phaseSetting : phaseSettings) {
            input = processInput(numbers, phaseSetting, input);
        }
        return input;
    }

    static List<String> generatePermutations(String array) {
        ArrayList<String> permutations = new ArrayList<>();
        if (array.length() == 0) {
            return permutations;
        }

        permutations(array.toCharArray(), 0, array.length(), permutations);
        return permutations;
    }

    private static void permutations(char[] arr, int loc, int len, ArrayList<String> result) {
        if (loc == len) {
            result.add(new String(arr));
            return;
        }

        // Pick the element to put at arr[loc]
        permutations(arr, loc + 1, len, result);
        for (int i = loc + 1; i < len; i++) {
            // Swap the current arr[loc] to position i
            swap(arr, loc, i);
            permutations(arr, loc + 1, len, result);
            // Restore the status of arr to perform the next pick
            swap(arr, loc, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
