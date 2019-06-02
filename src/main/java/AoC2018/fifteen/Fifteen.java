package AoC2018.fifteen;

import AoC2018.thirteen.Thirteen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Fifteen {

    public static void fight() {
        Unit elf1 = new Elf(new Point(1,1));
        Unit goblin1 = new Goblin(new Point(2,3));

        System.out.println(elf1.getAttackPoints());
        System.out.println(elf1.getPosition());
    }

    public static List<Unit> getInitialUnitPositions(char[][] matrix){
        List<Unit> unitList = new ArrayList<>();
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == 'G') {
                    unitList.add(new Goblin(new Point(x, y)));
                }
                if (matrix[y][x] == 'E') {
                    unitList.add(new Elf(new Point(x, y)));
                }
            }
        }

        return unitList;
    }
}
