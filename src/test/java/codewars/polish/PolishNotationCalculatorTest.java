package codewars.polish;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolishNotationCalculatorTest {
    private PolishNotationCalculator calc = new PolishNotationCalculator();

    @Test
    public void shouldWorkWithEmptyString() {
        assertEquals(0, calc.evaluate(""), 0);
    }

    @Test
    public void shouldParseNumbers() {
        assertEquals(3, calc.evaluate("3"), 0);
    }

    @Test
    public void shouldParseFloatNumbers() {
        assertEquals(3.5, calc.evaluate("3.5"), 0);
    }

    @Test
    public void shouldSupportAddition() {
        assertEquals(4, calc.evaluate("1 3 +"), 0);
    }

    @Test
    public void shouldSupportMultiplication() {
        assertEquals( 3, calc.evaluate("1 3 *"), 0);
    }

    @Test
    public void shouldSupportSubstraction() {
        assertEquals(-2, calc.evaluate("1 3 -"), 0);
    }

    @Test
    public void shouldSupportDivision() {
        assertEquals(2, calc.evaluate("4 2 /"), 0);
    }
}