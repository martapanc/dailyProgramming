package sudoku;

import org.junit.Test;

public class SudokuSolverTest {

    @Test
    public void solveSudoku() {

    }

    @Test
    public void printSudoku() {
        SudokuSolver.printSudoku("1".repeat(81));
        SudokuSolver.printSudoku("123456789".repeat(9));
    }
}