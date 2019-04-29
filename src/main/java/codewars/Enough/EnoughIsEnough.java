package codewars.Enough;

import java.util.*;

public class EnoughIsEnough {

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> newElements = new ArrayList<>();

        for (int i : elements) {
            if (Collections.frequency(newElements, i) < maxOccurrences) {
                newElements.add(i);
            }
        }

        return newElements.stream().mapToInt(i->i).toArray();
    }

}
