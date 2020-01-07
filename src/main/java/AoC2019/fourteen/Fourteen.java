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
        List<Chemical> initialChemicalList = map.get(new Chemical(1, "FUEL"));

        for (Chemical chemical : initialChemicalList) {
            for (Map.Entry<Chemical, List<Chemical>> entry : map.entrySet()) {
                if (entry.getKey().equalsName(chemical)) {

                    int quantity = chemical.getQuantity() * entry.getKey().getQuantity();

                    Chemical chemicalSearch = findChemicalInList(chemical.getName(), neededChemicals);
                    if (chemicalSearch != null) {
                        neededChemicals.get(neededChemicals.indexOf(chemicalSearch)).setQuantity(chemicalSearch.getQuantity() +  quantity);
                    } else {
                        neededChemicals.add(new Chemical(quantity, chemical.getName()));
                    }
                }
            }
        }

        System.out.println(neededChemicals);
    }

    private static Chemical findChemicalInList(String name, List<Chemical> chemicals) {
        return chemicals.stream().filter(carnet -> carnet.getName().equals(name)).findFirst().orElse(null);
    }
}
