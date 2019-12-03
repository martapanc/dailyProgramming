package AoC2019.three;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Three {

    public static Paths readInput(String input) {
        Paths paths = new Paths();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));

            paths = new Paths(
                    Arrays.stream(reader.readLine().split(","))
                            .map(s -> new Instruction(Direction.getDirectionFromId(s.substring(0, 1)), s.substring(1)))
                            .collect(Collectors.toList()),
                    Arrays.stream(reader.readLine().split(","))
                            .map(s -> new Instruction(Direction.getDirectionFromId(s.substring(0, 1)), s.substring(1)))
                            .collect(Collectors.toList())
            );

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paths;
    }
}
