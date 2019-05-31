package AoC2018.twelve;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
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

    static Map<String, String> read_input_rules(String inputRulesFile) {

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

    static Map<String, Character> read_input_rules_2(String inputRulesFile) {

        Map<String, Character> ruleMap = new HashMap<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(inputRulesFile));
            String line = reader.readLine();
            while (line != null) {
                String[] rule = line.split(" => ");
                ruleMap.put(rule[0], rule[1].charAt(0));
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ruleMap;
    }

    public static long findPotsWithPlants(String inputFile, String inputFileRules, long targetGens) {
        long sum = 0;

        char[] input = read_input(inputFile);
        Map<String, Character> rules = read_input_rules_2(inputFileRules);

        // List starting from input. Add . at the beginning if #, and count how many are added -> then shift

        List<Character> plantList = new ArrayList<>();
        int shifts = 0;
        for (char c : input) {
            plantList.add(c);
        }

        int generations = 0;
        while (generations < targetGens) {

            shifts += addDotsIfNeeded(plantList);
            List<Character> newGen = new ArrayList<>(plantList);

            for (int i = 2; i < plantList.size() - 2; i++) {
                String pattern = getNeighborsOfPlant(plantList, i);
                newGen.remove(i);
                newGen.add(i, rules.getOrDefault(pattern, '.'));
            }

            plantList = newGen;

            generations += 1;

            System.out.println(plantList);
        }


        return sum;
    }

    public static String getNeighborsOfPlant(List<Character> list, int index) {

        return "" + list.get(index - 2) + list.get(index - 1) + list.get(index) + list.get(index + 1) + list.get(index + 2);
    }

    private static int addDotsIfNeeded(List<Character> list) {

        if (list.get(list.size() - 1) == '#') {
            list.add(list.size(), '.');
            list.add(list.size(), '.');
            list.add(list.size(), '.');
        }

        if (list.get(list.size() - 2) == '#' && list.get(list.size() - 1) == '.') {
            list.add(list.size(), '.');
            list.add(list.size(), '.');
        }
        if (list.get(list.size() - 3) == '#' && list.get(list.size() - 2) == '.' && list.get(list.size() - 1) == '.') {
            list.add(list.size(), '.');
        }

        if (list.get(0) == '#') {
            list.add(0, '.');
            list.add(0, '.');
            return 2;
        }
        if (list.get(0) == '.' && list.get(1) == '#') {
            list.add(0, '.');
            return 1;
        }
        return 0;
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

            newGen.printAsAString();

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
                sum -= gens*2 - i;
            }
        }
        return sum;
    }

    public static long findPotsWithPlantsAfterGenerations_2(String inputFile, String inputFileRules, long gens) {
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

            newGen.printAsAString();

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
                sum -= gens*2 - i;
            }
        }
        return sum;
    }
}
