package AoC2019.fifteen;

import AoC2019.nine.Nine;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FifteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/fifteen/input1";

    @Test
    public void testReadInput() {
        System.out.println(Nine.readInput(INPUT1));
    }

    @Test
    public void testProcessInput() {
        System.out.println(Fifteen.processInput(Nine.readInput(INPUT1)));
    }

    @Test
    public void getRelativeWestOfCurrentDirection() {
        assertEquals(Direction.WEST, Fifteen.getRelativeWestOfCurrentDirection(Direction.NORTH));
        assertEquals(Direction.NORTH, Fifteen.getRelativeWestOfCurrentDirection(Direction.EAST));
        assertEquals(Direction.EAST, Fifteen.getRelativeWestOfCurrentDirection(Direction.SOUTH));
        assertEquals(Direction.SOUTH, Fifteen.getRelativeWestOfCurrentDirection(Direction.WEST));
    }
}
