package AoC2018.thirteen;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Cursor {

    public Direction direction;
    public Point currentPos;
    public Turn nextTurn;
    public char trackCellType;
    public Point nextPos;

    public Cursor(Direction direction, Point currentPos, Turn nextTurn, char trackCellType) {
        this.direction = direction;
        this.currentPos = currentPos;
        this.nextTurn = nextTurn;
        this.trackCellType = trackCellType;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Point getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(Point currentPos) {
        this.currentPos = currentPos;
    }

    public Turn getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    public char getTrackCellType() {
        return trackCellType;
    }

    public void setTrackCellType(char trackCellType) {
        this.trackCellType = trackCellType;
    }

    public Point getNextPos() {
        return nextPos;
    }

    public void setNextPos(Point nextPos) {
        this.nextPos = nextPos;
    }
}

enum Turn {
    LEFT(0), STRAIGHT(1), RIGHT(2);
    private int i;
    private static Map map = new HashMap<>();

    Turn(int i) {
        this.i = i;
    }

    public int getTurnVal(){
        return this.i;
    }
    static {
        for (Turn t: Turn.values()) {
            map.put(t.i, t);
        }
    }

    public static Turn valueOf(int i) {
        return (Turn) map.get(i);
    }
}

enum Direction {
    NORTH('^'), SOUTH('v'), EAST('>'), WEST('<');
    private char dir;
    private static Map map = new HashMap<>();

    Direction(char dir) {
        this.dir = dir;
    }

    public char getDirChar() {
        return this.dir;
    }

    static {
        for (Direction d : Direction.values()) {
            map.put(d.dir, d);
        }
    }

    public static Direction valueOf(char direction) {
        return (Direction) map.get(direction);
    }

}
