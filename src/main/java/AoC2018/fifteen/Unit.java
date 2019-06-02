package AoC2018.fifteen;

import java.awt.*;

public class Unit {

    private int attackPoints;
    private int hitPoints;
    Point position;
    private boolean alive = true;

    public Unit(Point position) {
        this.position = position;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setDead() {
        this.alive = false;
    }

    @Override
    public String toString() {
        return "Unit(" + position.x + "," + position.y + ")";
    }
}
