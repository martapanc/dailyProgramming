package AoC2018.eight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EightTest {

    @Test
    void test_sumMetadata() {

        String input1 = "src/test/java/AoC2018/eight/input";
        String input2 = "src/test/java/AoC2018/eight/input2";
        String input3 = "src/test/java/AoC2018/eight/input3";
        String input4 = "src/test/java/AoC2018/eight/input4";

        assertEquals(37262, Eight.sumMetadata(input1));
        assertEquals(138, Eight.sumMetadata(input2));
        assertEquals(104, Eight.sumMetadata(input4));
        assertEquals(99, Eight.sumMetadata(input3));
    }

    @Test
    void test_getRootScore() {

        String input1 = "src/test/java/AoC2018/eight/input";
        String input2 = "src/test/java/AoC2018/eight/input2";

        assertEquals(20839, Eight.getRootScore(input1));
        assertEquals(66, Eight.getRootScore(input2));
    }
}