package sudoku;

public class SudokuSolver {

    private static final int horLines = 25;

    public static String solveSudoku(String input) {

        return "";
    }

    static char[][] readSudoku(String input) {
        char[][] sudokuMatrix = new char[9][9];
        char[] chars = input.toCharArray();
        int count = 0;
        for (int y = 0; y < sudokuMatrix.length; y++) {
            for (int x = 0; x < sudokuMatrix[y].length; x++) {
                sudokuMatrix[x][y] = chars[count++];
            }
        }
        return sudokuMatrix;
    }

    static void printSudoku(String input) {
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
                System.out.println();
            }
            if (i % 27 == 26) {
                System.out.println("-".repeat(25));
            }
        }
    }

    static void printSudoku(char[][] sudokuMatrix) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < sudokuMatrix.length; y++) {
            for (int x = 0; x < sudokuMatrix[y].length; x++) {
                stringBuilder.append(sudokuMatrix[x][y]);
            }
        }

        printSudoku(stringBuilder.toString());
    }
}
