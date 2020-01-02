package AoC2019.twelve;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Twelve {

    public static ArrayList<Point3d> readInput(String input) {
        ArrayList<Point3d> list = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(input));
            String line = reader.readLine();
            while (line != null) {
                String[] tuple = line.replace("<", "").replace("x", "")
                        .replace("y", "").replace("z", "")
                        .replaceAll("=", "").replace(">", "").split(", ");
                list.add(new Point3d(tuple[0], tuple[1], tuple[2]));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Point3d> computeMovements(ArrayList<Point3d> list, int steps) {
        while (steps-- > 0) {
            for (Point3d moon : list) {
                ArrayList<Point3d> otherMoons = new ArrayList<>(list);
                otherMoons.remove(moon);

                int xSpeed = moon.getxSpeed();
                int ySpeed = moon.getySpeed();
                int zSpeed = moon.getzSpeed();

                for (Point3d otherMoon : otherMoons) {
                    if (moon.getX() < otherMoon.getX()) {
                        xSpeed++;
                    }
                    if (moon.getX() > otherMoon.getX()) {
                        xSpeed--;
                    }
                    if (moon.getY() < otherMoon.getY()) {
                        ySpeed++;
                    }
                    if (moon.getY() > otherMoon.getY()) {
                        ySpeed--;
                    }
                    if (moon.getZ() < otherMoon.getZ()) {
                        zSpeed++;
                    }
                    if (moon.getZ() > otherMoon.getZ()) {
                        zSpeed--;
                    }
                }

                moon.setSpeed(xSpeed, ySpeed, zSpeed);
            }

            for (Point3d moon : list) {
                moon.setX(moon.getX() + moon.getxSpeed());
                moon.setY(moon.getY() + moon.getySpeed());
                moon.setZ(moon.getZ() + moon.getzSpeed());
            }
        }

        return list;
    }

    public static int computeTotalEnergyAfterNSteps(ArrayList<Point3d> list, int steps) {
        return computeMovements(list, steps).stream().mapToInt(moon -> moon.getPotentialEnergy() * moon.getKineticEnergy()).sum();
    }
}
