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
        assertEquals(325, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 20));
        assertEquals(3337, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 20));
//        assertEquals(3337, Twelve.findPotsWithPlantsAfterGenerations(INPUT2, INPUT2_RULES, 1000));
    }

    @Test
    void test_findPotsWithPlants() {
        assertEquals(325, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 20));

        assertEquals(1374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 100));
        assertEquals(2374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 150));
        assertEquals(3374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 200));
        assertEquals(5374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 300));
        assertEquals(9374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 500));
//        assertEquals(19374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 1000));
//        assertEquals(99374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 5000));
//        assertEquals(999374, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT2, INPUT2_RULES, 50000));

        assertEquals(3337, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 20));

        assertEquals(8749, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 100));
        assertEquals(13249, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 150));
        assertEquals(17549, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 200));
        assertEquals(17635, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 201));
        assertEquals(17721, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 202));
        assertEquals(17807, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 203));
        assertEquals(26149, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 300));
        assertEquals(43349, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 500));
//        assertEquals(77749, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 900));
//        assertEquals(86349, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 1000));
//        assertEquals(430349, Twelve.findPotsWithPlantsAfterGenerations_2(INPUT1, INPUT1_RULES, 5000));
    }
}