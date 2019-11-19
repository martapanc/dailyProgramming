package sudoku;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuSolver {

    private static final int horLines = 25;

    public static String solveSudoku(String input) {

        char[][] sudokuMatrix = readSudoku(input);

        Map<Integer, List<Cell>> boxMap = new HashMap<>();
        boxMap.put(1, generateBoxPointArray(0,0));
        boxMap.put(2, generateBoxPointArray(0,3));
        boxMap.put(3, generateBoxPointArray(0,6));
        boxMap.put(4, generateBoxPointArray(3,0));
        boxMap.put(5, generateBoxPointArray(3,3));
        boxMap.put(6, generateBoxPointArray(3,6));
        boxMap.put(7, generateBoxPointArray(6,0));
        boxMap.put(8, generateBoxPointArray(6,3));
        boxMap.put(9, generateBoxPointArray(6,6));

        System.out.println(boxMap);
        return "";
    }

    static List<Cell> generateBoxPointArray(int startX, int startY) {
        List<Cell> points = new ArrayList<>();
        for (int y = startY; y < startY + 3; y++) {
            for (int x = startX; x < startX + 3; x++) {
                points.add(new Cell(x, y));
            }
        }

        return points;
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
