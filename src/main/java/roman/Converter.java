package roman;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;

public class Converter {


    public static int ConvertRomanNumeralToInteger(String numeral) {

        int result = 0;
        Map<Character, Integer> romanToIntegerMap = genRomanNumeralToIntegerMap();
        numeral = numeral.toUpperCase();

        char[] charArray = numeral.toCharArray();

        for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            if (i+1 < charArrayLength) {
                char nextC = charArray[i+1];
                if (romanToIntegerMap.get(c) < romanToIntegerMap.get(nextC)) {
                    result += romanToIntegerMap.get(nextC) - romanToIntegerMap.get(c);
                    i += 1;
                } else {
                    result += romanToIntegerMap.get(c);
                }
            } else {
                result += romanToIntegerMap.get(c);
            }
        }

        return result;

    }

    public static String ConvertIntegerToRomanNumeral(int number) {

        String result = "";
        int numOfDigits = (number + "").length();

        for (int i = 0; i < numOfDigits; i++) {
            int curr = (number % 10) * (int) Math.pow(10, i);


            number = number / 10;
        }

        return result;
    }

    private static BiMap<Character, Integer> genRomanNumeralToIntegerMap() {
        BiMap<Character, Integer> romanToIntegerMap = HashBiMap.create();

        romanToIntegerMap.put('I', 1);
        romanToIntegerMap.put('V', 5);
        romanToIntegerMap.put('X', 10);
        romanToIntegerMap.put('L', 50);
        romanToIntegerMap.put('C', 100);
        romanToIntegerMap.put('D', 500);
        romanToIntegerMap.put('M', 1000);
        return romanToIntegerMap;
    }

    private static BiMap<Integer, Character> genIntegerToRomanNumeralMap() {
        return genRomanNumeralToIntegerMap().inverse();
    }
}
