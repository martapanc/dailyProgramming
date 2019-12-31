package AoC2019.nine;

public class Output {
    private String code;
    private int index;
    private int relativeBase;

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

    public Output(String code, long index) {
        this.code = code;
        this.index = (int) index;
    }

    public Output(String code, long index, int relativeBase) {
        this.code = code;
        this.index = (int) index;
        this.relativeBase = relativeBase;
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

    public int getRelativeBase() {
        return relativeBase;
    }

    public void setRelativeBase(int relativeBase) {
        this.relativeBase = relativeBase;
    }
}
