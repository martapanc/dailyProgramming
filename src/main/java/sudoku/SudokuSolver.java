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

    static String solveSudokuWithBacktracking(String input) {
        LinkedHashMap<Cell, Integer> sudokuMap = readSudokuToMapZerosOnly(input);

        printSudoku(mapToStringZerosOnly(sudokuMap));
        return "";
    }

    static String solveSudoku(String input) {

        // Use LinkedHashedMap to keep the insertion order (left-right, top-bottom)
        LinkedHashMap<Cell, Set<Integer>> sudokuMap = readSudokuToMap(input);
        LinkedHashMap<Cell, Set<Integer>> sudokuMapCopy;

        do {
            sudokuMapCopy = copySudokuMap(sudokuMap);

            for (Map.Entry<Cell, Set<Integer>> entry : sudokuMap.entrySet()) {
                if (entry.getValue().size() != 1) {
                    LinkedHashSet<Cell> columnRowAndBoxCells = getColumnRowAndBoxCells(entry.getKey());

                    Set<Integer> existingNumbers = getExistingNumbers(columnRowAndBoxCells, sudokuMap);
                    Set<Integer> possibleValues = entry.getValue();

                    possibleValues.removeAll(existingNumbers);
                    sudokuMap.put(entry.getKey(), possibleValues);
                }
            }
        } while (!sudokuMap.equals(sudokuMapCopy));

        return mapToString(sudokuMap);
    }

    private static String mapToString(LinkedHashMap<Cell, Set<Integer>> sudokuMap) {
        StringBuilder sudokuString = new StringBuilder();

        for (Set<Integer> values : sudokuMap.values()) {
            if (values.size() == 1) {
                sudokuString.append(new ArrayList<>(values).get(0));
            } else {
                sudokuString.append("0");
            }
        }
        return sudokuString.toString();
    }

    private static String mapToStringZerosOnly(LinkedHashMap<Cell, Integer> sudokuMap) {
        StringBuilder sudokuString = new StringBuilder();
        for (Integer value : sudokuMap.values()) {
            sudokuString.append((value.equals(0) ? "0" : value));
        }
        return sudokuString.toString();
    }

    private static LinkedHashMap<Cell, Set<Integer>> copySudokuMap(LinkedHashMap<Cell, Set<Integer>> sudokuMap) {
        LinkedHashMap<Cell, Set<Integer>> copy = new LinkedHashMap<>();

        for (Map.Entry<Cell, Set<Integer>> entry : sudokuMap.entrySet()) {
            copy.put(new Cell(entry.getKey().x, entry.getKey().y), new HashSet<>(entry.getValue()));
        }

        return copy;
    }

    // Get all cells that are on the same column or row, or in the same box, as the current cell,
    // (excluding the current cell itself)
    static LinkedHashSet<Cell> getColumnRowAndBoxCells(Cell current) {
        LinkedHashSet<Cell> columnRowAndBoxCells = new LinkedHashSet<>();

        for (int i = 0; i < 9; i++) {
            columnRowAndBoxCells.add(new Cell(current.x, i));
            columnRowAndBoxCells.add(new Cell(i, current.y));
        }

        // Add all cells in the box of the current cells
        columnRowAndBoxCells.addAll(generateBoxPointMap()
                .values()
                .stream()
                .filter(cells -> cells.contains(current)).collect(Collectors.toList()).get(0));
        columnRowAndBoxCells.remove(current);
        return columnRowAndBoxCells;
    }

    static Set<Integer> getExistingNumbers(LinkedHashSet<Cell> columnRowAndBoxCells, LinkedHashMap<Cell, Set<Integer>> sudokuMap) {
        Set<Integer> existingValues = new HashSet<>();

        for (Cell cell : columnRowAndBoxCells) {
            List<Integer> values = new ArrayList<>(sudokuMap.get(cell));
            if (values.size() == 1) {
                existingValues.add(values.get(0));
            }
        }

        return existingValues;
    }

    private static Map<Integer, Set<Cell>> generateBoxPointMap() {
        Map<Integer, Set<Cell>> boxMap = new HashMap<>();

        int count = 1;
        for (int x = 0; x <= 6; x += 3) {
            for (int y = 0; y <= 6; y += 3) {
                boxMap.put(count++, generateBoxPointArray(x, y));
            }
        }
        return boxMap;
    }

    private static Set<Cell> generateBoxPointArray(int startX, int startY) {
        Set<Cell> points = new HashSet<>();
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

    static LinkedHashMap<Cell, Set<Integer>> readSudokuToMap(String input) {
        LinkedHashMap<Cell, Set<Integer>> sudokuMap = new LinkedHashMap<>();
        char[] chars = input.toCharArray();
        int count = 0;

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Set<Integer> values = new HashSet<>();

                if (chars[count] == '0') {
                    // Add numbers 1-9, which represent all possibilities for an empty cell
                    values = Arrays.stream(IntStream.range(1, 10).toArray()).boxed().collect(Collectors.toSet());
                } else {
                    values.add(Character.getNumericValue(chars[count]));
                }
                sudokuMap.put(new Cell(x, y), values);

                count++;
            }
        }

        return sudokuMap;
    }

    static LinkedHashMap<Cell, Integer> readSudokuToMapZerosOnly(String input) {
        LinkedHashMap<Cell, Integer> sudokuMap = new LinkedHashMap<>();
        char[] chars = input.toCharArray();
        int count = 0;

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                sudokuMap.put(new Cell(x, y), chars[count] == '0' ? 0 : Character.getNumericValue(chars[count]));
                count++;
            }
        }
        return sudokuMap;
    }

    static void printSudoku(String input) {
        char[] chars = input.toCharArray();
        final int COUNT = 25;

        System.out.println("-".repeat(COUNT));
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
                System.out.println("-".repeat(COUNT));
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
