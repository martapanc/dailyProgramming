package codewars.pins;

public class Solution {

    public static boolean validatePin(String pin) {
        // Your code here...
        boolean match = pin.matches("[0-9]+");
        return pin.matches("\\d{4}|\\d{6}");
    }
}
