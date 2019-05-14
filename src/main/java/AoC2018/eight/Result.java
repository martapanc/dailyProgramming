package AoC2018.eight;

public class Result {

    public int total;
    public int score;
    public int[] data;

    public Result(int total, int score, int[] data) {
        this.total = total;
        this.score = score;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public int getScore() {
        return score;
    }

    public int[] getData() {
        return data;
    }

}
