package AoC2019.thirteen;

import AoC2019.nine.Nine;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThirteenTest {

    private static final String INPUT1 = "src/test/java/AoC2019/thirteen/input1";
    private static final String INPUT2 = "src/test/java/AoC2019/thirteen/input2";

    @Test
    public void testReadInput() {
        ArrayList<Long> list = Nine.readInput(INPUT1);
        System.out.println(list);
        assertEquals(2710, list.size());
    }

    @Test
    public void testProcessInput() {
        System.out.println(Thirteen.processInput(Nine.readInput(INPUT1)));
    }

    @Test
    public void testCountTilesOfType() {
        System.out.println(Thirteen.processInput(Nine.readInput(INPUT2)));
    }

    @Test
    public void testPrintTileMap() {
        Thirteen.printTileMap(Thirteen.processInput(Nine.readInput(INPUT1)));
        Thirteen.printTileMap(Thirteen.processInput(Nine.readInput(INPUT2)));
    }
}