package AoC2018.one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DayOne {

    public static int frequencyCalculator(String s) {
        return IntStream.of(Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).toArray()).sum();
    }

    public static String readInput(String inputRulesFile) {

        String formattedInput = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputRulesFile));
            String line = reader.readLine();
            while (line != null) {
                formattedInput += line + ", ";
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formattedInput;
    }
}
