package AoC2019.five;

public class Output {
    private String code;
    private int index;

    public Output(String code) {
        this.code = code;
    }

    public Output(int index) {
        this.index = index;
    }

    public Output(String code, int index) {
        this.code = code;
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public int getIndex() {
        return index;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
