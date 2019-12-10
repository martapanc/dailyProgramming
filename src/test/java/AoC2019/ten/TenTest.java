package AoC2019.ten;

import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/ten/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/ten/input2";
    private static final String INPUT3 = "src/test/java/AoC2019/ten/input3";
    private static final String INPUT4 = "src/test/java/AoC2019/ten/input4";
    private static final String INPUT5 = "src/test/java/AoC2019/ten/input5";
    private static final String INPUT6 = "src/test/java/AoC2019/ten/input6";

    @Test
    public void testReadInput() {
        List<SpacePoint> list = Ten.readInput(INPUT1);
        assertEquals(25, list.size());
        System.out.println(list);
    }

    @Test
    public void getLineEquationFromTwoPoints() {
        assertEquals("x = 4.0", Ten.getLineEquationFromTwoPoints(new Point(4,1), new Point(4, 15)));
        assertEquals("y = 3.0", Ten.getLineEquationFromTwoPoints(new Point(0,3), new Point(2, 3)));

        assertEquals("y = 2.0x", Ten.getLineEquationFromTwoPoints(new Point(0,0), new Point(1, 2)));
        assertEquals("y = 2.0x + 1.0", Ten.getLineEquationFromTwoPoints(new Point(0,1), new Point(1, 3)));
        assertEquals("y = -1.4545454545454546x + 34.45454545454545", Ten.getLineEquationFromTwoPoints(new Point(23,1), new Point(12, 17)));
        assertEquals("y = 0.18181818181818182x + 0.6363636363636364", Ten.getLineEquationFromTwoPoints(new Point(2,1), new Point(13, 3)));

        assertEquals("The points overlap", Ten.getLineEquationFromTwoPoints(new Point(0,3), new Point(0, 3)));
    }
}
