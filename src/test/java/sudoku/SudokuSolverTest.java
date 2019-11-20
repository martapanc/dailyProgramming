package sudoku;

import org.junit.Test;

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
}
