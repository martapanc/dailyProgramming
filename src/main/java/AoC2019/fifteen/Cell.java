package AoC2019.fifteen;

import lombok.Data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Cell {

    private Point coordinate;
    private CellType type;
    private List<Direction> visited = new ArrayList<>();
    private List<Direction> notVisited = new ArrayList<>(Arrays.asList(Direction.values()));

    static Map<Direction, Boolean> directionsVisited = new HashMap<>();

    static {
        for (Direction d : Direction.values()) {
            directionsVisited.put(d, false);
        }
    }

    public Cell(CellType cellType) {
        this.type = cellType;
    }

    public Cell(CellType type, List<Direction> notVisited) {
        this.type = type;
        this.notVisited = notVisited;
    }
}

enum CellType {

    WALL('░'), PATH('█'), OXIGEN_THING('*');

    private char symbol;

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}