package AoC2018.twelve;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PlantArray {

    private char[] plantArray;
    private int minNegativeIndex = -2;

    /* Initialise array with two '.' at the beginning and at the end */
    public PlantArray(char[] array) {
        this.plantArray = new char[array.length + 4];
        IntStream.of(0, 1, this.plantArray.length - 2, this.plantArray.length - 1).forEach(i -> this.plantArray[i] = '.');
        System.arraycopy(array, 0, this.plantArray, 2, array.length);
    }

    public PlantArray(PlantArray oldGen){
        this.plantArray = new char[oldGen.size()];
        Arrays.fill(this.plantArray, '.');
    }

    @Override
    public String toString() {
        return Arrays.toString(plantArray);
    }

    public void printAsAString(){
        System.out.println(new String(this.plantArray));
    }

    public String getNeighborsOfPlant(int index) {
        String neighbors = "";
        for (int i = index - 2; i <= index + 2; i++) {
            neighbors += plantArray[i];
        }
        return neighbors;
    }

    public int getMinNegativeIndex() {
        return minNegativeIndex;
    }

    public void setMinNegativeIndex(int minNegativeIndex) {
        this.minNegativeIndex = minNegativeIndex;
    }

    public int size() {
        return this.plantArray.length;
    }

    public void setPlantAt(int index, char plant) {
        this.plantArray[index] = plant;
    }

    public char[] getArray(){
        return this.plantArray;
    }

    public char getChar(int index) {
        return this.plantArray[index];
    }
}
