package AoC2019.seven;

import java.util.ArrayList;

public class LoopAmplifierOutput {

    private int outputValue;
    private int lastIndex;
    private ArrayList<Integer> currentNumbers;

    public LoopAmplifierOutput(int outputValue, int lastIndex, ArrayList<Integer> numbers) {
        this.outputValue = outputValue;
        this.lastIndex = lastIndex;
        this.currentNumbers = numbers;
    }

    public int getOutputValue() {
        return outputValue;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public ArrayList<Integer> getNumbers() {
        return currentNumbers;
    }

    @Override
    public String toString() {
        return "{" +
                "outputValue=" + outputValue +
                ", lastIndex=" + lastIndex +
                ", currentNumbers=" + currentNumbers +
                '}';
    }
}
