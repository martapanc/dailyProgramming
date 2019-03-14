package two;

import java.util.Arrays;

public class TwoPointFive {

    public static String idChecker(String[] idList) {

        String result = "";
        for (String id : idList) {
            for (int i = Arrays.asList(idList).indexOf(id)+1; i < idList.length; i++) {
                if (doStringsDifferByOneLetterOnly(id, idList[i])) {
                    result += compareStrings(id, idList[i]);
                    System.out.println(id + " " + idList[i]);
                }
            }
        }
        return result;
    }

    public static String compareStrings(String first, String second) {
        if (first.length() != second.length()) {
            return "-";
        }

        StringBuilder diff = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (diff.length() != 0) {
                    diff.append(" ");
                }

                diff.append(first.charAt(i)).append(second.charAt(i));
            }
        }

        return diff.toString();
    }

    public static boolean doStringsDifferByOneLetterOnly(String first, String second) {
        String differences = compareStrings(first, second);
        return differences.length() == 2;
    }
}
