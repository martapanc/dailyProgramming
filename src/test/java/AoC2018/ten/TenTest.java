package AoC2018.ten;

import org.junit.Test;

import java.util.stream.IntStream;

public class TenTest {

    private final String input1 = "src/test/java/AoC2018/ten/input1";
    private final String input2 = "src/test/java/AoC2018/ten/input2";
    private final String input3 = "src/test/java/AoC2018/ten/input3";

    @Test
    public void test_compute_coordinates() {
        Ten.computeCloseCoordinates(Ten.readInput(input1), 0);
        Ten.computeCloseCoordinates(Ten.readInput(input3), 0);
    }

    @Test
    public void test_compute() {
        IntStream.range(0, 4).forEach(s -> Ten.compute(Ten.readInput(input2), s));
    }

    @Test
    public void test_compute_2() {
        IntStream.range(10515, 10525).forEach(s -> Ten.compute(Ten.readInput(input1), s));
        Ten.compute(Ten.readInput(input1), 10519);
    }

    @Test
    public void test_compute_3() {
        IntStream.range(10032, 10042).forEach(s -> Ten.compute(Ten.readInput(input3), s));
        Ten.compute(Ten.readInput(input3), 10036);
    }
}