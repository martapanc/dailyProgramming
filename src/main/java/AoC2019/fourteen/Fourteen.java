package AoC2019.fourteen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Start from the list that produces 1 FUEL
// For every chemical, find the list that produces it
// Divide the needed amount by the quantity produced; if remainder != 0, take ceil(result).
// Save ceil(result) - needed amount as a "storage" for the current element
// For the following chem reductions, check if current chem is in storage. If so, subtract the stored value from the needed amount and continue
// Continue until the "producers list" only contains ORE

public class Fourteen {
    public static Map<Chemical, List<Chemical>> readInput(String input) {
        Map<Chemical, List<Chemical>> chemicalListMap = new HashMap<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                String[] reaction = line.split(" => ");
                String[] consumed = reaction[0].split(", ");
                List<Chemical> consumedChemicals = Arrays.stream(consumed)
                        .map(consumedChemical -> consumedChemical.split(" "))
                        .map(c -> new Chemical(Integer.parseInt(c[0]), c[1]))
                        .collect(Collectors.toList());

                String[] produced = reaction[1].split(" ");
                Chemical producedChemical = new Chemical(Integer.parseInt(produced[0]), produced[1]);

                chemicalListMap.put(producedChemical, consumedChemicals);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chemicalListMap;
    }

    public static int computeChemicals(Map<Chemical, List<Chemical>> map) {
        List<Chemical> neededChemicals;
        List<Chemical> chemicalList = map.get(new Chemical(1, "FUEL"));
        List<Chemical> storage = new ArrayList<>();
        int oreTotal = 0;

        int i = 100;
        while (i-- > 0) {
            neededChemicals = new ArrayList<>();

            for (Chemical chemical : chemicalList) {
                Map.Entry<Chemical, List<Chemical>> producerAndList = findProducersOfChemical(chemical.getName(), map);
                Chemical producer = producerAndList.getKey();

                Chemical chemInStorage = findChemicalInList(producer.getName(), storage);
                if (chemInStorage != null) {
                    if (chemInStorage.getQuantity() > chemical.getQuantity()) {
                        int diff = chemInStorage.getQuantity() - chemical.getQuantity();
                        chemical = new Chemical(0, chemical.getName());
                        storage.remove(chemInStorage);
                        storage.add(new Chemical(diff, chemical.getName()));
                    } else {
                        chemical = new Chemical(chemical.getQuantity() - chemInStorage.getQuantity(), chemical.getName());
                        storage.remove(chemInStorage);
                    }
                }
                int remainder;
                int multiplier = 1;

                if (chemical.getQuantity() < producer.getQuantity()) {
                    remainder = producer.getQuantity() - chemical.getQuantity();
                    if (chemical.getQuantity() == 0) { //TODO: check
                        multiplier = 0;
                    }
                } else {
                    multiplier = (int) Math.ceil((double) chemical.getQuantity() / producer.getQuantity());
                    remainder = multiplier * producer.getQuantity() - chemical.getQuantity();
                }
                if (remainder != 0 && chemical.getQuantity() != 0) { //TODO: check
                    Chemical chem = findChemicalInList(producer.getName(), storage);
                    if (chem != null) {
                        int wasteSoFar = chem.getQuantity();
                        storage.remove(chem);
                        storage.add(new Chemical(wasteSoFar + remainder, producer.getName()));
                    } else {
                        storage.add(new Chemical(remainder, producer.getName()));
                    }
                }

                for (Chemical chem : producerAndList.getValue()) {
                    if (chem.getName().equals("ORE")) {
                        oreTotal += chem.getQuantity() * multiplier;
                    } else {
                        neededChemicals.add(new Chemical(chem.getQuantity() * multiplier, chem.getName()));
                    }
                }
            }
            chemicalList = new ArrayList<>(neededChemicals);
            if (neededChemicals.isEmpty()) {
                break;
            }
        }

        return oreTotal;
    }

    private static Chemical findChemicalInList(String name, List<Chemical> chemicals) {
        return chemicals.stream()
                .filter(carnet -> carnet.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static Map.Entry<Chemical, List<Chemical>> findProducersOfChemical(String name, Map<Chemical, List<Chemical>> map) {
        return map.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
