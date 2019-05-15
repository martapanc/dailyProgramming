package AoC2018.ten;

public class MovingPoint {

    private int positionX;
    private int positionY;
    private int speedX;
    private int speedY;

    public MovingPoint(int positionX, int positionY, int speedX, int speedY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    @Override
    public String toString() {
        return "{" + positionX +
                ", " + positionY +
                ", " + speedX +
                ", " + speedY +
                '}';
    }
}
