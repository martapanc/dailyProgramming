package five;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiveTest {

    @Test
    public void test_compute_alchemical_reduction() {
        String input = Five.readInputFile("src/main/java/five/in1");
        assertEquals("dabCBAcaDA", Five.computeAlchemicalReduction(input));
    }

    @Test
    public void test_compute_alchemical_reduction_length() {
        String input = Five.readInputFile("src/main/java/five/in1");
        assertEquals(10, Five.computeAlchemicalReductionLength(input));
    }

    @Test
    public void test_compute_alchemical_reduction_2() {
        String input = Five.readInputFile("src/main/java/five/in2");
        assertEquals(10638, Five.computeAlchemicalReductionLength(input));
    }
    @Test
    public void test_compute_alchemical_reduction_3() {
        String input = Five.readInputFile("src/main/java/five/in3");
        assertEquals("yj", Five.computeAlchemicalReduction(input));
    }

    @Test
    public void test_char_remove_at() {
        assertEquals("mara", Five.charRemoveAt("marta", 3));
    }

    @Test
    public void test_remove_all_letter() {
        assertEquals("dabCBAcaDA", Five.removeAllLetter("daFbCBfAcaFfDA", "f"));
    }
}
