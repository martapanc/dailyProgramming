package AoC2018.three;

import java.util.List;

public class Item {

    private int id;
    private List<String> coordinates;

    public Item(int id, List<String> coordinates) {
        this.id = id;
        this.coordinates = coordinates;
    }

    public List<String> getCoordinates() {
        return coordinates;
    }

    public int getId() {
        return id;
    }
}
