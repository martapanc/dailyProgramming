package AoC2018.fifteen;

import java.awt.*;

public class Elf extends Unit {

    private int attackPoints = 3;
    private int hitPoints = 200;

    public Elf(Point position) {
        super(position);
    }

    public Elf(Point position, String name) {
        super(position, name);
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public char getIdChar() {
        return 'E';
    }

    @Override
    public void setIdChar(char idChar) {
        super.setIdChar(idChar);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String toString() {
        return name + "[" + hitPoints + "](" + position.x + "," + position.y + ")";
    }
}
