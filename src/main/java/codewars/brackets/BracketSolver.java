package codewars.brackets;

import java.util.Arrays;
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
}
