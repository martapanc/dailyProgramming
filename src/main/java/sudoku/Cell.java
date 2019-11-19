package sudoku;

import java.awt.*;

public class Cell extends Point {

    public Cell(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ";" + y +")";
    }
}
