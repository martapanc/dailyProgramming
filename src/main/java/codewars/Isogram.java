package codewars;

import java.util.*;
import java.util.stream.Collectors;

public class Isogram {

    public static boolean isIsogram(String str) {
        return (str.length() == new HashSet<>(
                str.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList())
        ).size());
    }

    public static boolean isIsogram2(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
