package AoC2018.twelve;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class TwelveTest {

    private final String INPUT1 = "src/test/java/AoC2018/twelve/input1";
    private final String INPUT1_RULES = "src/test/java/AoC2018/twelve/input1_rules";
    private final String INPUT2 = "src/test/java/AoC2018/twelve/input2";
    private final String INPUT2_RULES = "src/test/java/AoC2018/twelve/input2_rules";
    private final String INPUT3 = "src/test/java/AoC2018/twelve/input3";
    private final String INPUT3_RULES = "src/test/java/AoC2018/twelve/input3_rules";

    @Test
    void read_input() {
//        System.out.println(Twelve.read_input(INPUT1));
        System.out.println(Twelve.read_input(INPUT2));
    }

    @Test
    void read_input_rules() {
//        System.out.println(Twelve.read_input_rules(INPUT1_RULES));
        System.out.println(Twelve.read_input_rules(INPUT2_RULES));
    }

    @Test
    void doThings() {
        assertEquals(325, Twelve.findPotsWithPlantsAfterGenerations(INPUT2, INPUT2_RULES, 20));
        assertEquals(3337, Twelve.findPotsWithPlantsAfterGenerations(INPUT1, INPUT1_RULES, 20));
        assertEquals(3337, Twelve.findPotsWithPlantsAfterGenerations(INPUT1, INPUT1_RULES, 500));
    }
}