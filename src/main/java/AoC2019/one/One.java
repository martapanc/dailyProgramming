package AoC2019.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class One {

    static int calculateFuelForModel(int mass) {
        return (mass / 3) - 2;
    }

    static int calculateTotalFuel(String input) {
        List<Integer> list = readInput(input);
        int sum = 0;

        for (Integer i : list) {
            sum += calculateFuelForModel(i);
        }

        return sum;
    }

    public static List<Integer> readInput(String input) {
        List<Integer> integerList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                integerList.add(Integer.parseInt(line));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }
}
