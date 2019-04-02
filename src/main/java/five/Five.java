package five;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Five {

    public static String computeAlchemicalReduction(String input) {

        String output = "";
        int k = 0;

        while (k < 100000) {
            for (int i = 0; i < input.length() - 1; i++) {
                int initLength = input.length();

                int thisAscii = input.charAt(i);
                int nextAscii = input.charAt(i + 1);
                if (thisAscii + 32 == nextAscii || thisAscii - 32 == nextAscii) {
                    output = charRemoveAt(input, i);
                    output = charRemoveAt(output, i);
                    input = output;
                    break;
                }
            }
            k++;
        }

        if (output.length() != 0)
            return output;
        return input;
    }

    public static int computeAlchemicalReductionLength(String input) {

        String output = computeAlchemicalReduction(input);
        return output.length();
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    public static String readInputFile(String filepath) {
        BufferedReader reader;
        String line = "";
        try {

            reader = new BufferedReader(new FileReader(filepath));
            line = reader.readLine();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static String removeAllLetter(String input, String letter) {

        return input.replace(letter.toLowerCase(), "").replace(letter.toUpperCase(), "");
    }
}
