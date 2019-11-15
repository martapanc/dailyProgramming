package codewars.squaredArray;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquaredArrayTest {

    @Test
    public void comp() {
        assertTrue(SquaredArray.comp(new int[]{1}, new int[]{1}));
        assertTrue(SquaredArray.comp(new int[]{1, 2}, new int[]{1, 4}));
        assertTrue(SquaredArray.comp(new int[]{1, 3, 4}, new int[]{9, 1, 16}));
        assertTrue(SquaredArray.comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11}, new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361}));
        assertTrue(SquaredArray.comp(new int[]{0}, new int[]{0}));
        assertTrue(SquaredArray.comp(new int[]{0, -14, 191, 161, 19, 144, 195, 1}, new int[]{1, 0, 14 * 14, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195}));
        assertTrue(SquaredArray.comp(new int[]{}, new int[]{}));

        assertFalse(SquaredArray.comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11}, new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361}));
        assertFalse(SquaredArray.comp(new int[]{121, 144, 19, 161, 19, 144, 19, 11}, new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361}));
        assertFalse(SquaredArray.comp(new int[]{1}, new int[]{}));
        assertFalse(SquaredArray.comp(new int[]{1}, null));
        assertFalse(SquaredArray.comp(null, new int[]{1}));
        assertFalse(SquaredArray.comp(null, null));
    }
}