package AoC2019.four;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FourTest {

    private static final int MIN = 172930;
    private static final int MAX = 683082;

    @Test
    public void testFindPasswordCombinations() {
        assertEquals(1675, Four.findPasswordCombinations(MIN, MAX));
        assertEquals(1142, Four.findPasswordCombinationsPart2(MIN, MAX));
    }

    @Test
    public void testIsValidPassword() {
        assertTrue(Four.isValidPassword("123455"));
        assertTrue(Four.isValidPassword("111111"));
        assertTrue(Four.isValidPassword("122344"));

        assertFalse(Four.isValidPassword("223450"));
        assertFalse(Four.isValidPassword("123456"));
    }

    @Test
    public void testIsValidPasswordPart2() {
        assertTrue(Four.isValidPasswordPart2("123455"));
        assertTrue(Four.isValidPasswordPart2("122344"));
        assertTrue(Four.isValidPasswordPart2("112233"));
        assertTrue(Four.isValidPasswordPart2("112222"));
        assertTrue(Four.isValidPasswordPart2("111122"));

        assertFalse(Four.isValidPasswordPart2("123444"));
        assertFalse(Four.isValidPasswordPart2("111111"));
        assertFalse(Four.isValidPasswordPart2("223450"));
        assertFalse(Four.isValidPasswordPart2("123456"));
    }
}
