package AoC2018.twelve;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Twelve {

    static char[] read_input(String inputFile) {

        char[] chars = null;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            chars = line.toCharArray();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return chars;
    }

    static Map read_input_rules(String inputRulesFile) {

        Map<String, String> ruleMap = new HashMap<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputRulesFile));
            String line = reader.readLine();
            while (line != null) {
                String[] rule = line.split(" => ");
                ruleMap.put(rule[0], rule[1]);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ruleMap;
    }

    public static long findPotsWithPlantsAfterGenerations(String inputFile, String inputFileRules, long gens) {
        char[] input = read_input(inputFile);
        Map<String, String> rules = read_input_rules(inputFileRules);

        PlantArray plants = new PlantArray(input);

        plants.printAsAString();

        PlantArray newGen = null;

        int generations = 0;
        while (generations < gens) {

            newGen = new PlantArray(plants);
            for (int i = 2; i < plants.size() - 2; i++) {
                String pattern = plants.getNeighborsOfPlant(i);
                if (rules.containsKey(pattern)) {
                    newGen.setPlantAt(i, rules.get(pattern).charAt(0));
                }
            }

//            newGen.printAsAString();

            plants = new PlantArray(newGen.getArray());
            generations += 1;
        }

        List<Character> result = new ArrayList<>();


        for (long i = gens*2; i < newGen.size() - gens; i++) {
            result.add(newGen.getChar((int) i));
        }

        long sum = IntStream.range(0, result.size()).filter(i -> result.get(i) == '#').sum();

        for (long i = (gens*2 -1); i > 0; i--) {
            if (newGen.getArray()[(int) i] == '#') {
                sum -= 40-i;
            }
        }

        return sum;
    }
}
