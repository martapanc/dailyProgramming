package AoC2019.eleven;

import AoC2019.nine.Nine;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ElevenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/eleven/input1";

    @Test
    public void testReadInput() {
        ArrayList<Long> list = Nine.readInput(INPUT1);
        assertEquals(648, list.size());
        System.out.println(list);
    }

    @Test
    public void testProcessInput() {
        System.out.println(Eleven.processInput(Nine.readInput(INPUT1)));
    }
}
