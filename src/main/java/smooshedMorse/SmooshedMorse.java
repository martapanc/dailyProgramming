package smooshedMorse;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SmooshedMorse {

    private static final String MORSE_ALPHABET = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
    private static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

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
}
