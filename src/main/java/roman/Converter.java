package roman;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.lang3.StringUtils;

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

        StringBuilder result = new StringBuilder();
        int numOfDigits = (number + "").length();

        for (int i = 0; i < numOfDigits; i++) {
            int curr = (number % 10) * (int) Math.pow(10, i);

            number = number / 10;

            if (curr == 0)
                continue;

            result.insert(0, convertSimpleIntegerToNumeral(curr));

        }

        return result.toString();
    }

    public static String convertSimpleIntegerToNumeral(int number) {

        String numeral;
        int digit;

        if (number > 999) {
            digit = number / 1000;
            numeral = StringUtils.repeat("M", digit);
        } else if (number > 99) {
            digit = number / 100;
            if (digit == 4)
                numeral = "CD";
            else if (digit == 9)
                numeral = "CM";
            else if (digit < 4)
                numeral = StringUtils.repeat("C", digit);
            else
                numeral = "D" + StringUtils.repeat("C", digit-5);
        } else if (number > 9) {
            digit = number / 10;
            if (digit == 4)
                numeral = "XL";
            else if (digit == 9)
                numeral = "XC";
            else if (digit < 4)
                numeral = StringUtils.repeat("X", digit);
            else
                numeral = "L" + StringUtils.repeat("X", digit-5);
        } else {
            digit = number;
            if (digit == 4)
                numeral = "IV";
            else if (digit == 9)
                numeral = "IX";
            else if (digit < 4)
                numeral = StringUtils.repeat("I", digit);
            else
                numeral = "V" + StringUtils.repeat("I", digit-5);
        }
        return numeral;
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
