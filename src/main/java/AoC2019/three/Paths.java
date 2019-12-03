package AoC2019.three;

import java.util.List;

public class Paths {

    private List<Instruction> paths1;
    private List<Instruction> paths2;

    public Paths(List<Instruction> paths1, List<Instruction> paths2) {
        this.paths1 = paths1;
        this.paths2 = paths2;
    }

    public Paths() {
    }

    @Override
    public String toString() {
        return "Path1 = " + paths1 +
                "\nPath2 = " + paths2;
    }
}
