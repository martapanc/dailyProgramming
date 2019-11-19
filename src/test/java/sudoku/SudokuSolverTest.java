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

    @Test
    public void readSudoku() {
        SudokuSolver.printSudoku(SudokuSolver.readSudoku("987654321".repeat(9)));
    }
}