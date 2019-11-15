package codewars.squaredArray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SquaredArray {

    public static boolean comp(int[] a, int[] b) {
        if (a != null & b != null && a.length == b.length) {
            Arrays.setAll(a, i -> Math.abs(a[i]));
            Arrays.sort(a);
            Arrays.sort(b);
            return IntStream.range(0, a.length).noneMatch(i -> b[i] != Math.pow(a[i], 2));
        }
        return false;
    }
}
