package AoC2019.three;

import java.util.HashMap;
import java.util.Map;

public class Instruction {

    private Direction direction;
    private String value;

    public Instruction(Direction direction, String value) {
        this.direction = direction;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + direction +
                ", " + value + "}";
    }
}

enum Direction {
    UP("U"), DOWN("D"), RIGHT("R"), LEFT("L");

    private String id;
    private static Map<String, Direction> map = new HashMap<>();

    Direction(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    static {
        for (Direction d : Direction.values()) {
            map.put(d.getId(), d);
        }
    }

    static Direction getDirectionFromId(String id) {
        return map.get(id);
    }
}