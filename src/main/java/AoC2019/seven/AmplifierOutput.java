package AoC2019.seven;

public class AmplifierOutput {

    private int outputValue;
    private int lastIndex;

    public AmplifierOutput(int outputValue, int lastIndex) {
        this.outputValue = outputValue;
        this.lastIndex = lastIndex;
    }

    public int getOutputValue() {
        return outputValue;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}
