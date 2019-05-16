package AoC2018.eleven;

public class Eleven {

    static int computePowerLevelOfCell(int x, int y, int GRID_SN) {

        int rackID = x + 10;
        int powerLevel = rackID * y;
        powerLevel += GRID_SN;
        powerLevel *= rackID;
        powerLevel = powerLevel / 100 % 10;
        return powerLevel - 5;
    }

    static void createMatrix(int GRID_SN){
        int[][] matrix = new int[300][300];
        for (int y = 0; y < 300; y++){
            for (int x = 0; x < 300; x++){
                matrix[y][x] = computePowerLevelOfCell(x+1, y+1, GRID_SN);
            }
        }

        for (int y = 0; y < 300; y++) {
            for (int x = 0; x < 300; x++) {
                if (matrix[y][x] >= 0)
                    System.out.print(" " + matrix[y][x] + "\t");
                else
                    System.out.print(matrix[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[] find3x3CellWithLargestPower(int GRID_SN){
        int[] maxPowerCell = new int[]{0, 0, 0};

        for (int y = 0; y < 298; y++){
            for (int x = 0; x < 298; x++){
                int totalPower = find3x3CellPower(x, y, GRID_SN);
                if (totalPower > maxPowerCell[2]) {
                    maxPowerCell[0] = x;
                    maxPowerCell[1] = y;
                    maxPowerCell[2] = totalPower;
                }
            }
        }
        return maxPowerCell;
    }

    static int[] find_KxK_CellWithLargestPower(int GRID_SN, int kMin, int kMax){
        int[] maxPowerCell = new int[]{0, 0, -10000, 0};

        for (int k = kMin; k <= kMax; k++) {
            for (int y = 0; y < 301-k; y++){
                for (int x = 0; x < 301-k; x++){
                    int totalPower = findKxKCellPower(x, y, k, GRID_SN);
                    if (totalPower > maxPowerCell[2]) {
                        maxPowerCell[0] = x;
                        maxPowerCell[1] = y;
                        maxPowerCell[2] = totalPower;
                        maxPowerCell[3] = k;
                    }
                }
            }
        }
        return maxPowerCell;
    }

    static int find3x3CellPower(int topLeftX, int topLeftY, int GRID_SN) {
        int power = 0;
        for (int y = topLeftY; y < topLeftY+3; y++){
            for (int x = topLeftX; x < topLeftX+3; x++){
                power += computePowerLevelOfCell(x, y, GRID_SN);
            }
        }
        return power;
    }

    static int findKxKCellPower(int topLeftX, int topLeftY, int k, int GRID_SN) {
        int power = 0;
        for (int y = topLeftY; y < topLeftY+k; y++){
            for (int x = topLeftX; x < topLeftX+k; x++){
                power += computePowerLevelOfCell(x, y, GRID_SN);
            }
        }
        return power;
    }
}
