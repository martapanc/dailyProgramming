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

    public void setTrackCellType(char trackCellType) {
        this.trackCellType = trackCellType;
    }

    public void setNextPos(Point nextPos) {
        this.nextPos = nextPos;
    }

    public Point getCurrentPos() {
        return currentPos;
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
