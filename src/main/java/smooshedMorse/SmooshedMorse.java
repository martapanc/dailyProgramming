package smooshedMorse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SmooshedMorse {

    private static final String MORSE_ALPHABET = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
    private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String INPUT = "src/main/java/smooshedMorse/enable1.txt";

    static String encode(String string) {
        Map<Character, String> encodingMap = createEncodingMap();
        for (Map.Entry<Character, String> entry : encodingMap.entrySet()) {
            string = string.replace(entry.getKey().toString(), entry.getValue());
        }
        return string;
    }

    private static Map<Character, String> createEncodingMap() {
        char[] alphabetArray = ENGLISH_ALPHABET.toCharArray();
        String[] morseArray = MORSE_ALPHABET.split(" ");

        return IntStream.range(0, alphabetArray.length).boxed()
                .collect(Collectors.toMap(i -> alphabetArray[i], i -> morseArray[i], (a, b) -> b));
    }

    static void findEncodingWith15Dashes() {
        BufferedReader reader;
        Map<String, String> map = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(INPUT));
            String line = reader.readLine();
            while (line != null) {
                map.put(line, encode(line));
                line = reader.readLine();
            }
            reader.close();

            map.entrySet().stream()
                    .filter(entry -> entry.getValue().contains("-".repeat(15)))
                    .findFirst()
                    .ifPresent(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void findSameSequenceFor13DifferentWords() {
        BufferedReader reader;
        Map<String, Integer> map = new HashMap<>();
        try {
            reader = new BufferedReader(new FileReader(INPUT));
            String line = reader.readLine();
            while (line != null) {
                String encoding = encode(line);
                if (map.containsKey(encoding)) {
                    int currentAmount = map.get(encoding);
                    map.put(encoding, ++currentAmount);
                } else {
                    map.put(encoding, 1);
                }
                line = reader.readLine();
            }
            reader.close();
            map.entrySet().stream().filter(entry -> entry.getValue() == 13).findFirst().ifPresent(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
