package AoC2018.seven;

public class Dependency implements Comparable< Dependency >{

    public String before;
    public String after;

    public Dependency(String before, String after) {
        this.before = before;
        this.after = after;
    }

    @Override
    public String toString() {
        return before + " -> " + after;
    }

    @Override
    public int compareTo(Dependency o) {
        if (this.before.equals(o.before)) {
            return this.after.compareTo(o.after);
        }
        return this.before.compareTo(o.before);
    }
}

//CABDFE
//AOSTVW