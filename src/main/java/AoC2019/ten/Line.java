package AoC2019.ten;

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
}
