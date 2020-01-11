package AoC2019.nine;

import lombok.Data;

@Data
public class Output {
    private String code;
    private int index;
    private int relativeBase;
    private int indexOfLatestInputOpcode = -1;

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

    public Output(String code, int index, int indexOfLatestInputOpcode) {
        this.code = code;
        this.index = index;
        this.indexOfLatestInputOpcode = indexOfLatestInputOpcode;
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

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", index=" + index +
                ", relativeBase=" + relativeBase +
                ", indexOfLatestInputOpcode=" + indexOfLatestInputOpcode +
                '}';
    }
}
