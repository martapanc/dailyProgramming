package AoC2019.ten;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SpacePoint {

    private Point coordinate;
    private SpaceItem spaceItem;

    public SpacePoint(Point coordinate, SpaceItem spaceItem) {
        this.coordinate = coordinate;
        this.spaceItem = spaceItem;
    }

    @Override
    public String toString() {
        return "{(" + coordinate.x + "," + coordinate.y + "), " + spaceItem + "}";
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public SpaceItem getSpaceItem() {
        return spaceItem;
    }
}


enum SpaceItem {
    ASTEROID('#'), VOID('.');

    private char id;
    private static Map<Character, SpaceItem> map = new HashMap<>();

    SpaceItem(char id) {
        this.id = id;
    }

    public char getId() {
        return this.id;
    }

    static {
        for (SpaceItem d : SpaceItem.values()) {
            map.put(d.getId(), d);
        }
    }

    static SpaceItem getSpaceItemFromId(char id) {
        return map.get(id);
    }
}