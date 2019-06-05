package AoC2018.fifteen;

import java.awt.*;

public class Elf extends Unit {

    private int attackPoints = 3;
    private int hitPoints = 200;

    public Elf(Point position) {
        super(position);
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
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
    public String toString() {
        return "Elf[" + hitPoints + "](" + position.x + "," + position.y + ")";
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void setDead() {
        super.setDead();
    }

    @Override
    public char getIdChar() {
        return 'E';
    }

    @Override
    public void setIdChar(char idChar) {
        super.setIdChar(idChar);
    }
}
