package codewars.brackets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BracketSolverTest {

    @Test
    public void areBracketsValid() {
        assertTrue(BracketSolver.areBracketsValid("()"));
        assertTrue(BracketSolver.areBracketsValid("([])"));
        assertTrue(BracketSolver.areBracketsValid("([]{})"));
        assertTrue(BracketSolver.areBracketsValid("()[{()}[]]"));
        assertFalse(BracketSolver.areBracketsValid("("));
        assertFalse(BracketSolver.areBracketsValid("]"));
        assertFalse(BracketSolver.areBracketsValid("([)]"));
        assertFalse(BracketSolver.areBracketsValid("([{])"));
    }
}