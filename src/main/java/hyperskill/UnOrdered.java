package hyperskill;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UnOrdered {

    public static boolean isOrdered(String[] args) {
        boolean ascending = true;
        boolean descending = true;
        List<Integer> list = Arrays.stream(args).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1)) {
                descending = false;
            }
            if (list.get(i) < list.get(i - 1)) {
                ascending = false;
            }
        }

        return ascending || descending;
    }
}
