package sudoku;

public class SudokuSolver {

    private static final int horLines = 25;

    public static String solveSudoku(String input) {

        return "";
    }

    public static void printSudoku(String input) {
        char[] chars = input.toCharArray();

        System.out.println("-".repeat(horLines));
        for (int i = 0; i < chars.length; i++) {
            char num = chars[i];
            if (i % 9 == 0) {
                System.out.print("| ");
            }
            System.out.print(num + " ");
            if (i % 3 == 2) {
                System.out.print("| ");
            }
            if (i % 9 == 8) {
                System.out.println("");
            }
            if (i % 27 == 26) {
                System.out.println("-".repeat(25));
            }
        }
    }
}
