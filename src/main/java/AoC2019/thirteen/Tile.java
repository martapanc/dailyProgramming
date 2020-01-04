package AoC2019.thirteen;

import java.util.HashMap;
import java.util.Map;

public enum Tile {
    EMPTY(0), WALL(1), BLOCK(2), HORIZONTAL_PADDLE(3), BALL(4);

    private static Map map = new HashMap<>();

    static {
        for (Tile t : Tile.values()) {
            map.put(t.id, t);
        }
    }

    private int id;

    Tile(int id) {
        this.id = id;
    }

    public static Tile valueOf(int tileId) {
        return (Tile) map.get(tileId);
    }

    public int getTileId() {
        return this.id;
    }
}
