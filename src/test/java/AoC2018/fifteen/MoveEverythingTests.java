package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveEverythingTests {

    private final String input1 = "src/test/java/AoC2018/fifteen/input1";
    private final String input2 = "src/test/java/AoC2018/fifteen/input2";
    private final String input_progress = "src/test/java/AoC2018/fifteen/input_progress";
    private final String input28 = "src/test/java/AoC2018/fifteen/input28";

    private final String fight1 = "src/test/java/AoC2018/fifteen/fight1";
    private final String fight2 = "src/test/java/AoC2018/fifteen/fight2";
    private final String fight3 = "src/test/java/AoC2018/fifteen/fight3";

    @Test
    public void moveEverything_1() {
        char[][] matrix1 = Thirteen.readInput(input1, 9, 9);
        Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix1), matrix1, 4);
        assertEquals(24784, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix1), matrix1, 30));
    }

    @Test
    public void moveEverything_2(){
        char[][] matrix2 = Thirteen.readInput(input_progress, 7, 7);
        assertEquals(27730, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix2), matrix2, 48));
    }

    @Test
    public void moveEverything_3(){
        char[][] matrix3 = Thirteen.readInput(input28, 7, 7);
        Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix3), matrix3, 10);
    }

    @Test
    public void moveEverything_4(){
        char[][] matrix4 = Thirteen.readInput(fight1, 7, 7);
        assertEquals(36334, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix4), matrix4, 40));
    }

    @Test
    public void moveEverything_5(){
        char[][] matrix5 = Thirteen.readInput(fight2, 7, 7);
        assertEquals(39514, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix5), matrix5, 50));
    }

    @Test
    public void moveEverything_6(){
        char[][] matrix6 = Thirteen.readInput(fight3, 7, 7);
        assertEquals(27755, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix6), matrix6, 40));
    }

    @Test
    public void moveEverything_final(){
        char[][] matrix7 = Thirteen.readInput(input2, 32, 32);
        assertEquals(197538, Fifteen.moveEverything(Utils.getInitialUnitPositions(matrix7), matrix7, 1000));
    }
}
