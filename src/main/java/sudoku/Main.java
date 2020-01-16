package sudoku;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positives = 0;
        if (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length > 0) {
                for (String num : scanner.nextLine().split(" ")) {
                    if (Integer.parseInt(num) > 0) {
                        positives++;
                    }
                }
            }
        }

        System.out.println(positives == 1);

    }
}
