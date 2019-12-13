package AoC2019.six;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Six {

    public static List<OrbitSystem> readInput(String input) {
        List<OrbitSystem> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                String[] orbit = line.split("[)]");
                list.add(new OrbitSystem(orbit[0], orbit[1]));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    static Map<String, Set<String>> getOrbitMap(List<OrbitSystem> list) {
        Map<String, Set<String>> orbitMap = new HashMap<>();

        list.forEach(orbitSystem -> {
            String center = orbitSystem.getCenter();
            String satellite = orbitSystem.getSatellite();
            if (orbitMap.containsKey(center)) {
                orbitMap.get(center).add(satellite);
            } else {
                Set<String> satellites = new HashSet<>();
                satellites.add(satellite);
                orbitMap.put(center, satellites);
            }
        });

        return orbitMap;
    }

    static Map<String, Set<String>> getCompleteOrbitMap(List<OrbitSystem> list) {
        Map<String, Set<String>> orbitMap = getOrbitMap(list);
        int satelliteListsTotalLength = getListSizeSum(orbitMap);
        int tempTotalLength = 0;

        while (tempTotalLength != satelliteListsTotalLength) {
            satelliteListsTotalLength = getListSizeSum(orbitMap);

            Map<String, Set<String>> newOrbitMap = orbitMap.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> new HashSet<>(entry.getValue()), (a, b) -> b));

            for (Map.Entry<String, Set<String>> entry : orbitMap.entrySet()) {
                for (String sat : entry.getValue()) {
                    if (newOrbitMap.containsKey(sat)) {
                        newOrbitMap.get(entry.getKey()).addAll(orbitMap.get(sat));
                    }
                }
            }
            orbitMap = newOrbitMap;
            tempTotalLength = getListSizeSum(orbitMap);
        }

        return orbitMap;
    }

    static int getListSizeSum(Map<String, Set<String>> orbitMap) {
        return orbitMap.values().stream().mapToInt(Set::size).sum();
    }
}
