package AoC2018.eleven;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElevenTest {

    @Test
    void computePowerLevelOfCell() {
        assertEquals(4, Eleven.computePowerLevelOfCell(3,5,8));
        assertEquals(-5, Eleven.computePowerLevelOfCell(122,79,57));
        assertEquals(0, Eleven.computePowerLevelOfCell(217,196,39));
        assertEquals(4, Eleven.computePowerLevelOfCell(101,153,71));
    }

    @Test
    void createMatrix() {
        Eleven.createMatrix(8);
        Eleven.createMatrix(18);
        Eleven.createMatrix(42);
    }

    @Test
    void find3x3CellPower() {
        assertEquals(29, Eleven.find3x3CellPower(33,45,18));
        assertEquals(30, Eleven.find3x3CellPower(21,61,42));
    }

    @Test
    void find_KxK_CellPower() {
        assertEquals(29, Eleven.findKxKCellPower(33,45, 3,18));
        assertEquals(30, Eleven.findKxKCellPower(21,61, 3, 42));
    }

    @Test
    void find3x3CellWithLargestPower() {
        assertArrayEquals(new int[]{33, 45, 29}, Eleven.find3x3CellWithLargestPower(18));
        assertArrayEquals(new int[]{21, 61, 30}, Eleven.find3x3CellWithLargestPower(42));
        assertArrayEquals(new int[]{21, 37, 30}, Eleven.find3x3CellWithLargestPower(8561));
    }

    @Test
    void find_KxK_CellWithLargestPower() {
        assertArrayEquals(new int[]{33, 45, 29, 3}, Eleven.find_KxK_CellWithLargestPower(18, 3, 3));
        assertArrayEquals(new int[]{21, 61, 30, 3}, Eleven.find_KxK_CellWithLargestPower(42, 3, 3));
        assertArrayEquals(new int[]{21, 37, 30, 3}, Eleven.find_KxK_CellWithLargestPower(8561, 3, 3));

        assertArrayEquals(new int[]{90, 269, 113, 16}, Eleven.find_KxK_CellWithLargestPower(18, 5, 20));
        assertArrayEquals(new int[]{232, 251, 119, 12}, Eleven.find_KxK_CellWithLargestPower(42, 5, 20));
        assertArrayEquals(new int[]{236, 146, 160, 12}, Eleven.find_KxK_CellWithLargestPower(8561, 10, 20));
    }
}