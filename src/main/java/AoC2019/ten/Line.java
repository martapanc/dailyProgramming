package AoC2019.ten;

import java.awt.*;
import java.util.Objects;

public class Line {

    private double angularCoefficient;
    private double constant;
    private boolean x;
    private boolean y;

    public Line(double angularCoefficient, double constant, boolean x, boolean y) {
        this.angularCoefficient = angularCoefficient;
        this.constant = constant;
        this.x = x;
        this.y = y;
    }

    public Line(double angularCoefficient, double constant) {
        this.angularCoefficient = angularCoefficient;
        this.constant = constant;
        this.x = true;
        this.y = true;
    }

    public double getAngularCoefficient() {
        return angularCoefficient;
    }

    public double getConstant() {
        return constant;
    }

    public boolean isX() {
        return x;
    }

    public boolean isY() {
        return y;
    }

    @Override
    public String toString() {

        if (x && !y) {
            return "x = " + constant;
        }

        if (!x && y) {
            return "y = " + constant;
        }

        return "y = " + angularCoefficient + "x" + (constant != 0 ? " + " + constant : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Math.abs(line.angularCoefficient - angularCoefficient) < 0.01 &&
                Math.abs(line.constant - constant) < 0.01 &&
                x == line.x &&
                y == line.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(angularCoefficient, constant, x, y);
    }

    static String getLineEquationFromTwoPoints(Point p1, Point p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        if (p1.equals(p2)) {
            return "The points overlap";
        }

        if (y1 == y2) {
            return "y = " + y1;
        }

        if (x1 == x2) {
            return "x = " + x1;
        }

        double angularCoefficient = (y2 - y1) / (x2 - x1);
        double constant = (x2 * y1 - x1 * y2) / (x2 - x1);

        return "y = " + angularCoefficient + "x" + (constant != 0 ? " + " + constant : "");
    }

    static Line getLineFromTwoPoints(Point p1, Point p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();

        if (p1.equals(p2)) {
            return null;
        }

        if (y1 == y2) {
            return new Line(0, y1, false, true);
        }

        if (x1 == x2) {
            return new Line(0, x1, true, false);
        }

        double angularCoefficient = (y2 - y1) / (x2 - x1);
        double constant = (x2 * y1 - x1 * y2) / (x2 - x1);

        return new Line(angularCoefficient, constant);
    }

    static boolean doesPointBelongToLine(Point p, Line line) {
        if (line.x && !line.y) {
            return line.constant == p.getX();
        }

        if (!line.x && line.y) {
            return line.constant == p.getY();
        }

        return p.getY() == line.getAngularCoefficient() * p.getX() + line.getConstant();
    }
}
