package AoC2019.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Two {

    public static ArrayList<Integer> readInput(String input) {
        ArrayList<Integer> list = new ArrayList();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                Arrays.stream(line.split(",")).map(Integer::parseInt).forEachOrdered(list::add);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static int processInput(String input) {
        ArrayList<Integer> numbers = readInput(input);
        for (int i = 0; i < numbers.size(); i += 4) {
            Integer key = numbers.get(i);
            if (key == 99) {
                break;
            }
            Integer input1Pos = numbers.get(i + 1);
            Integer input2Pos = numbers.get(i + 2);
            Integer outputPos = numbers.get(i + 3);
            if (key == 1) {
                numbers.set(outputPos, numbers.get(input1Pos) + numbers.get(input2Pos));
            }
            if (key == 2) {
                numbers.set(outputPos, numbers.get(input1Pos) * numbers.get(input2Pos));
            }
        }

        return numbers.get(0);
    }
}
