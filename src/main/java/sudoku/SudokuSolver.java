package sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuSolver {

    /*
    Matrix with indices:
    00 01 02 | 03 04 05 | 06 07 08
    10 11 12 | 13 14 15 | 16 17 18
    20 21 22 | 23 24 25 | 26 27 28
    ---------+----------+---------
    30 31 32 | 33 34 35 | 36 37 38
    40 41 42 | 43 44 45 | 46 47 48
    50 51 52 | 53 54 55 | 56 57 58
    ---------+----------+---------
    60 61 62 | 63 64 65 | 66 67 68
    70 71 72 | 73 74 75 | 76 77 78
    80 81 82 | 83 84 85 | 86 87 88

    Boxes are counted like this:
     1 | 2 | 3
    ---+---+---
     4 | 5 | 6
    ---+---+---
     7 | 8 | 9

    */

    private static final int horLines = 25;

    public static String solveSudoku(String input) {

        // Use LinkedHashedMap to keep the insertion order (left-right, top-bottom)
        LinkedHashMap<Cell, List<Integer>> sudokuMap = readSudokuToMap(input);

        LinkedHashMap<Cell, List<Integer>> sudokuMapCopy = sudokuMap;

        for (Map.Entry<Cell, List<Integer>> entry : sudokuMap.entrySet()) {
            if (entry.getValue().size() != 1) {
                LinkedHashSet<Cell> columnRowAndBoxCells = getColumnRowAndBoxCells(entry.getKey(), sudokuMap);
                System.out.println(columnRowAndBoxCells);
            }
        }

        Map<Integer, List<Cell>> boxMap = generateBoxPointMap();
        System.out.println(boxMap);
        System.out.println(sudokuMap);
        return "";
    }

    // Get all cells that are on the same column or row, or in the same box, as the current cell,
    // (excluding the current cell itself)
    private static LinkedHashSet<Cell> getColumnRowAndBoxCells(Cell current, LinkedHashMap<Cell, List<Integer>> sudokuMapCopy) {
        LinkedHashSet<Cell> columnRowAndBoxCells = new LinkedHashSet<>();

        for (int i = 0; i < 9; i++) {
            columnRowAndBoxCells.add(new Cell(current.x, i));
            columnRowAndBoxCells.add(new Cell(i, current.y));
        }

        columnRowAndBoxCells.remove(current);
        return columnRowAndBoxCells;
    }

    private static Map<Integer, List<Cell>> generateBoxPointMap() {
        Map<Integer, List<Cell>> boxMap = new HashMap<>();

        int count = 1;
        for (int x = 0; x <= 6; x += 3) {
            for (int y = 0; y <= 6; y += 3) {
                boxMap.put(count++, generateBoxPointArray(x, y));
            }
        }
        return boxMap;
    }

    private static List<Cell> generateBoxPointArray(int startX, int startY) {
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

    static LinkedHashMap<Cell, List<Integer>> readSudokuToMap(String input) {
        LinkedHashMap<Cell, List<Integer>> sudokuMap = new LinkedHashMap<>();
        char[] chars = input.toCharArray();

        int count = 0;

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                List<Integer> values = new ArrayList<>();

                if (chars[count] == '0') {
                    // Add numbers 1-9, which represent all possibilities for an empty cell
                    values = Arrays.stream(IntStream.range(1, 10).toArray()).boxed().collect(Collectors.toList());
                } else {
                    values.add(Character.getNumericValue(chars[count]));
                }
                sudokuMap.put(new Cell(x, y), values);

                count++;
            }
        }

        return sudokuMap;
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
