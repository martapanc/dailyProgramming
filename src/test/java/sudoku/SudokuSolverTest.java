package sudoku;

import org.junit.Test;

import java.util.LinkedHashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SudokuSolverTest {

    private static final String ALL_NUMBERS = "123456789".repeat(9);
    private static final String ALL_NUMBERS_WITH_SOME_ZEROS = "08390261".repeat(10) + "0";
    private static final String ALL_NUMBERS_REVERSED = "987654321".repeat(9);
    private static final String ALL_ONES = "1".repeat(81);

    @Test
    public void solveSudoku() {
        SudokuSolver.solveSudoku(ALL_NUMBERS);
        SudokuSolver.solveSudoku(ALL_NUMBERS_WITH_SOME_ZEROS);
    }

    @Test
    public void printSudoku() {
        SudokuSolver.printSudoku(ALL_ONES);
        SudokuSolver.printSudoku(ALL_NUMBERS);
        SudokuSolver.printSudoku(ALL_NUMBERS_WITH_SOME_ZEROS);
    }

    @Test
    public void readSudoku() {
        SudokuSolver.printSudoku(SudokuSolver.readSudoku(ALL_NUMBERS_REVERSED));
    }

    @Test
    public void getColumnRowAndBoxCells() {
        LinkedHashSet<Cell> columnsRowAndBoxCells = new LinkedHashSet<>();
        columnsRowAndBoxCells.add(new Cell(0, 0));
        columnsRowAndBoxCells.add(new Cell(0, 1));
        columnsRowAndBoxCells.add(new Cell(0, 2));
        columnsRowAndBoxCells.add(new Cell(1, 0));
        columnsRowAndBoxCells.add(new Cell(1, 1));
        columnsRowAndBoxCells.add(new Cell(2, 0));
        columnsRowAndBoxCells.add(new Cell(2, 1));
        columnsRowAndBoxCells.add(new Cell(2, 2));
        columnsRowAndBoxCells.add(new Cell(3, 2));
        columnsRowAndBoxCells.add(new Cell(4, 2));
        columnsRowAndBoxCells.add(new Cell(5, 2));
        columnsRowAndBoxCells.add(new Cell(6, 2));
        columnsRowAndBoxCells.add(new Cell(7, 2));
        columnsRowAndBoxCells.add(new Cell(8, 2));
        columnsRowAndBoxCells.add(new Cell(1, 3));
        columnsRowAndBoxCells.add(new Cell(1, 4));
        columnsRowAndBoxCells.add(new Cell(1, 5));
        columnsRowAndBoxCells.add(new Cell(1, 6));
        columnsRowAndBoxCells.add(new Cell(1, 7));
        columnsRowAndBoxCells.add(new Cell(1, 8));

        LinkedHashSet<Cell> actual = SudokuSolver.getColumnRowAndBoxCells(new Cell(1, 2),
                SudokuSolver.readSudokuToMap(ALL_NUMBERS_WITH_SOME_ZEROS));
        assertEquals(20, actual.size());
        assertTrue(columnsRowAndBoxCells.containsAll(actual));
    }
}
