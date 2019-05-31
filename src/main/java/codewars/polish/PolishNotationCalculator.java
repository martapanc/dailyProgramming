package codewars.polish;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class PolishNotationCalculator {

    public double evaluate(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        List<String> list = Arrays.stream(s.split(" ")).collect(Collectors.toList());

        while (list.size() > 1) {
            for (int i = 0; i < list.size() - 2; i++) {
                try{
                    double first = Double.parseDouble(list.get(i));
                    double second = Double.parseDouble(list.get(i + 1));
                    String op = list.get(i + 2);
                    double result;
                    switch (op) {
                        case "+":
                            result = first + second; break;
                        case "-":
                            result = first - second; break;
                        case "*":
                            result = first * second; break;
                        case "/":
                            result = first / second; break;
                        default:
                            continue;
                    }

                    list.remove(i + 2);
                    list.remove(i + 1);
                    list.remove(i);
                    list.add(i, result + "");
                    break;
                }
                catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        return Double.parseDouble(list.get(0));
    }

    public double evaluateWithStack(String expr) {
        if (expr.equals("")) {
            return 0;
        }

        Stack<Double> stack = new Stack<Double>();
        String[] atoms = expr.split(" ");

        for (String atom: atoms) {
            Double a, b;
            switch (atom) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": b = stack.pop(); a = stack.pop(); stack.push(a - b); break;
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": b = stack.pop(); a = stack.pop(); stack.push(a / b); break;
                default:
                    stack.push(Double.parseDouble(atom));
            }
        }

        return stack.pop();
    }
}
