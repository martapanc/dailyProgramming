package roman;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.lang3.StringUtils;

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

            if (0 == curr)
                continue;

            result.insert(0, convertSimpleIntegerToNumeral(curr));

        }

        return result.toString();
    }

    private static String convertSimpleIntegerToNumeral(int number) {

        String numeral;
        int digit;

        if (number > 999) {
            digit = number / 1000;
            numeral = StringUtils.repeat("M", digit);
        } else if (number > 99) {
            numeral = getPartialNumber(number, 100, "CD", "CM", "C", "D");
        } else if (number > 9) {
            numeral = getPartialNumber(number, 10, "XL", "XC", "X", "L");
        } else {
            numeral = getPartialNumber(number, 1, "IV", "IX", "I", "V");
        }
        return numeral;
    }

    private static String getPartialNumber(int number, int div, String fourNum, String nineNum, String oneNum, String fiveNum) {
        int digit = number / div;
        if (4 == digit) {
            return fourNum;
        } else if (9 == digit) {
            return nineNum;
        } else if (digit < 4)
            return StringUtils.repeat(oneNum, digit);
        else {
            return fiveNum + StringUtils.repeat(oneNum, digit-5);
        }
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
}
