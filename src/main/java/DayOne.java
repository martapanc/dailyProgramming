import java.util.Arrays;
import java.util.stream.IntStream;

public class DayOne {

    public int frequencyCalculator(String s) {
        int[] inputFrequencies = Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).toArray();
        return IntStream.of(inputFrequencies).sum();
    }
}
