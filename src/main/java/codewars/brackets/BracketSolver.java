package codewars.brackets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BracketSolver {

    public static boolean areBracketsValid(String input) {

        Character[] opening = new Character[]{'(', '[', '{'};
        Character[] closing = new Character[]{')', ']', '}'};
        Stack<Character> stack = new Stack<>();
        for (Character c : input.toCharArray()) {
            if (Arrays.asList(closing).contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!opening[Arrays.asList(closing).indexOf(c)].equals(stack.lastElement())) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // Clever solution from CW
    public static boolean areBracketsValidWithoutStack(String s) {
        int len;
        do {
            len = s.length();
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        } while (len != s.length());
        return s.length() == 0;
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        List<Object> list  = new ArrayList(Arrays.asList(numbers));
        list.add(0, "(");
        list.add(4, ") ");
        list.add(8, "-");
        return  list.toString().replaceAll("[\\[\\]]", "").replaceAll(",", " ");
    }
}
