package AoC2019.sixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Sixteen {
    public static List<Integer> readInput(String input) {
        List<Integer> list = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                addNumbersToList(list, line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void addNumbersToList(List<Integer> list, String line) {
        for (char c : line.toCharArray()) {
            list.add(Character.getNumericValue(c));
        }
    }

    static List<Integer> readStringInput(String numbers) {
        List<Integer> list = new ArrayList<>();
        addNumbersToList(list, numbers);
        return list;
    }

    public static int computeNthDigit(List<Integer> numbers, int n) {
        int[] pattern = new int[]{0, 1, 0, -1};
        List<Integer> repeatedPattern = new ArrayList<>();
        int count = 1;
        int index = 0;

        int i = 0;
        while (i++ < numbers.size() + 1) {
            index = index % 4;
            repeatedPattern.add(pattern[index]);
            if (count >= n) {
                index++;
                count = 1;
            } else {
                count++;
            }
        }
        repeatedPattern.remove(0);
        return getOnesDigitOfComputation(numbers, repeatedPattern);
    }

    private static int getOnesDigitOfComputation(List<Integer> numbers, List<Integer> pattern) {
        return Math.abs(IntStream.range(0, numbers.size()).map(i -> numbers.get(i) * pattern.get(i)).sum() % 10);
    }
}
