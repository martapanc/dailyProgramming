package AoC2018.eight;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Eight {

    public static long sumMetadata(String inputFile) {

        int[] input = readInput(inputFile);

        if (input != null) {
            Result res = parse(input);
            return res.getTotal();
        } else {
            return -1;
        }
    }

    public static long getRootScore(String inputFile) {

        int[] input = readInput(inputFile);

        if (input != null) {
            Result res = parse(input);
            return res.getScore();
        } else {
            return -1;
        }
    }

    public static Result parse(int[] input) {
        int children = input[0];
        int metas = input[1];
        int[] input2 = Arrays.copyOfRange(input, 2, input.length);
        List<Integer> scores = new ArrayList<>();
        int totals = 0;

        for (int i = 0; i < children; i++) {
            Result res = parse(input2);
            totals += res.getTotal();
            scores.add(res.getScore());
            input2 = res.getData();
        }

        int[] currMetas = Arrays.copyOfRange(input2, 0, metas);
        int[] restOfInput = Arrays.copyOfRange(input2, metas, input2.length);

        totals += IntStream.of(currMetas).sum();
        if (children == 0) {
            return new Result(totals, IntStream.of(currMetas).sum(), restOfInput);
        } else {
            int sc = 0;
            for (int j : currMetas) {
                if (j > 0 && j <= scores.size()) {
                    sc += scores.get(j-1);
                }
            }
            return new Result(totals, sc, restOfInput);
        }
    }

    public static int[] readInput(String inputFile) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();

            int[] input = Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            reader.close();

            return input;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
