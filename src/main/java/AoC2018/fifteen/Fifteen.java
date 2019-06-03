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

    public static List<Point> findPossibleTargets(Unit playingUnit, List<Unit> unitList, char[][] matrix) {
        List<Point> pointList = new ArrayList<>();
        Class targetType;


        if (playingUnit instanceof Elf) {
            targetType = Goblin.class;
        } else {
            targetType = Elf.class;
        }

        for (Unit potentialTarget : unitList) {
            if (targetType.isInstance(potentialTarget)) {
                Point[] pointArray = new Point[] {
                    new Point(potentialTarget.position.x, potentialTarget.position.y - 1),
                    new Point(potentialTarget.position.x + 1, potentialTarget.position.y),
                    new Point(potentialTarget.position.x, potentialTarget.position.y + 1),
                    new Point(potentialTarget.position.x - 1, potentialTarget.position.y)
                };
                char[] charArray = new char[] {
                        matrix[pointArray[0].y][pointArray[0].x],
                        matrix[pointArray[1].y][pointArray[1].x],
                        matrix[pointArray[2].y][pointArray[2].x],
                        matrix[pointArray[3].y][pointArray[3].x]
                };
                for (int i = 0; i < pointArray.length; i++) {
                    if (!pointList.contains(pointArray[i]) && charArray[i] != '#' && charArray[i] != 'E' && charArray[i] != 'G') {
                        pointList.add(pointArray[i]);
                    }
                }

            }
        }

        return pointList;
    }
}
