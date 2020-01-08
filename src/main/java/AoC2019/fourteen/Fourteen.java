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

    public static void computeChemicals(Map<Chemical, List<Chemical>> map) {
        List<Chemical> neededChemicals = new ArrayList<>();
        List<Chemical> chemicalList = map.get(new Chemical(1, "FUEL"));

        int i = 10;
        while (i-- > 0) {

            int producedQuantity = 1;
            for (Chemical chemical : chemicalList) {
                for (Map.Entry<Chemical, List<Chemical>> entry : map.entrySet()) {
                    if (entry.getKey().equalsName(chemical)) {

                        int quantity = chemical.getQuantity() * producedQuantity;

                        Chemical chemicalSearch = findChemicalInList(chemical.getName(), neededChemicals);
                        if (chemicalSearch != null) {
                            neededChemicals.get(neededChemicals.indexOf(chemicalSearch)).setQuantity(chemicalSearch.getQuantity() + quantity);
                        } else {
                            neededChemicals.add(new Chemical(quantity, chemical.getName()));
                        }
                    }
                }
            }

            chemicalList = new ArrayList<>(neededChemicals);
        }

        System.out.println(neededChemicals);
    }

    private static Chemical findChemicalInList(String name, List<Chemical> chemicals) {
        return chemicals.stream().filter(carnet -> carnet.getName().equals(name)).findFirst().orElse(null);
    }

    static List<Chemical> findConsumedWithQuantitiesFromMap(Chemical chemical, Map<Chemical, List<Chemical>> map) {
        List<Chemical> consumedChems = new ArrayList<>();

        Chemical chem = map.entrySet().stream()
                .filter(entry -> entry.getKey().getName().equals(chemical.getName()))
                .findFirst().map(Map.Entry::getKey).orElse(null);

        if (chem != null) {
            for (Chemical c : map.get(chem)) {
                Chemical consumedWithQuantity = new Chemical(c.getQuantity() * chemical.getQuantity(), c.getName());
                consumedChems.add(consumedWithQuantity);
            }
        }

        return consumedChems;
    }
}
