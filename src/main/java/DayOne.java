import java.util.Arrays;
import java.util.stream.IntStream;

public class DayOne {

    public int frequencyCalculator(String s) {
        return IntStream.of(Arrays.stream(s.split(", ")).mapToInt(Integer::parseInt).toArray()).sum();
    }
}
