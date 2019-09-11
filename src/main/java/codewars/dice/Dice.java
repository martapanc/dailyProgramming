package codewars.dice;

import org.testng.annotations.*;

import java.util.*;
import java.util.stream.*;

import static org.testng.Assert.assertEquals;

public class Dice {
    public static int greedy(int[] dice){
        int finalScore = 0;
        int[] scores = {1000, 200, 300, 400, 500, 600, 10, 50};
        int[] occurrences = IntStream.range(0, 6).map(i -> countOccurrences(dice, i + 1)).toArray();

        int[] res = Arrays.stream(occurrences).filter(o -> o == 3).toArray();
        if (res.length == 1) {

        }

        return finalScore;
    }

    public static int countOccurrences(int[] dice, int number) {
        return (int) Arrays.stream(dice).filter(n -> n == number).count();
    }

    @Test
    public void testExample() {
        assertEquals(250, Dice.greedy(new int[]{5,1,3,4,1}));
        assertEquals(1100, Dice.greedy(new int[]{1,1,1,3,1}));
        assertEquals(450, Dice.greedy(new int[]{2,4,4,5,4}));
    }
}