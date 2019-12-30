package AoC2019.seven;

import AoC2019.two.Two;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SevenTest {

    private static final String PHASE_SETTINGS = "01234";

    private static String INPUT1 = "src/test/java/AoC2019/seven/input1";
    private static String INPUT2 = "src/test/java/AoC2019/seven/input2";
    private static String INPUT3 = "src/test/java/AoC2019/seven/input3";
    private static String INPUT4 = "src/test/java/AoC2019/seven/input4";

    @Test
    public void testReadInput() {
        System.out.println(Two.readInput(INPUT1));
        System.out.println(Two.readInput(INPUT2));
        System.out.println(Two.readInput(INPUT3));
        System.out.println(Two.readInput(INPUT4));
    }

    @Test
    public void testProcessInput() {
        assertEquals(4, Seven.processInput(Two.readInput(INPUT1), 4, 0));
        assertEquals(43, Seven.processInput(Two.readInput(INPUT1), 3, 4));
        assertEquals(432, Seven.processInput(Two.readInput(INPUT1), 2, 43));
        assertEquals(4321, Seven.processInput(Two.readInput(INPUT1), 1, 432));
        assertEquals(43210, Seven.processInput(Two.readInput(INPUT1), 0, 4321));

        assertEquals(5, Seven.processInput(Two.readInput(INPUT2), 0, 0));
        assertEquals(54, Seven.processInput(Two.readInput(INPUT2), 1, 5));
        assertEquals(543, Seven.processInput(Two.readInput(INPUT2), 2, 54));
        assertEquals(5432, Seven.processInput(Two.readInput(INPUT2), 3, 543));
        assertEquals(54321, Seven.processInput(Two.readInput(INPUT2), 4, 5432));

        assertEquals(6, Seven.processInput(Two.readInput(INPUT3), 1, 0));
        assertEquals(65, Seven.processInput(Two.readInput(INPUT3), 0, 6));
        assertEquals(652, Seven.processInput(Two.readInput(INPUT3), 4, 65));
        assertEquals(6521, Seven.processInput(Two.readInput(INPUT3), 3, 652));
        assertEquals(65210, Seven.processInput(Two.readInput(INPUT3), 2, 6521));
    }

    @Test
    public void setupAmplifiers() {
        assertEquals(43210, Seven.setupAmplifiers(Two.readInput(INPUT1), new int[]{4, 3, 2, 1, 0}));
        assertEquals(54321, Seven.setupAmplifiers(Two.readInput(INPUT2), new int[]{0, 1, 2, 3, 4}));
        assertEquals(12345, Seven.setupAmplifiers(Two.readInput(INPUT2), new int[]{4, 3, 2, 1, 0}));
        assertEquals(65210, Seven.setupAmplifiers(Two.readInput(INPUT3), new int[]{1, 0, 4, 3, 2}));
        assertEquals(1265, Seven.setupAmplifiers(Two.readInput(INPUT3), new int[]{2, 3, 4, 1, 0}));
    }

    @Test
    public void testGeneratePermutations() {
        assertEquals(1, Seven.generatePermutations("0").size());
        assertEquals(2, Seven.generatePermutations("01").size());
        assertEquals(6, Seven.generatePermutations("012").size());
        assertEquals(24, Seven.generatePermutations("1023").size());
        assertEquals(120, Seven.generatePermutations("12345").size());
        assertEquals(720, Seven.generatePermutations("123456").size());

        Seven.generatePermutations("0123").forEach(System.out::println);
    }

    @Test
    public void testFindBestResult() {
        assertEquals(43210, Seven.findBestResult(Two.readInput(INPUT1), PHASE_SETTINGS));
        assertEquals(54321, Seven.findBestResult(Two.readInput(INPUT2), PHASE_SETTINGS));
        assertEquals(54321, Seven.findBestResult(Two.readInput(INPUT2), PHASE_SETTINGS));
        assertEquals(65210, Seven.findBestResult(Two.readInput(INPUT3), PHASE_SETTINGS));
        assertEquals(67023, Seven.findBestResult(Two.readInput(INPUT4), PHASE_SETTINGS));
    }
}