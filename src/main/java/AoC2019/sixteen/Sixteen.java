package AoC2019.sixteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
