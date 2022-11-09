import java.util.List;
import java.util.ArrayList;

public class Map {
    
    private Cell[][] map;
    private int[][] solvedMap = new int[9][9];
    private NumGenerator numGenerator;
    private List<int[]> freeCellCoordinates = new ArrayList<int[]>();

    public Map() {
        this.map = new Cell[9][9];
        this.createMap();
        this.numGenerator = new NumGenerator();
        this.fillMapWithData();
    }

    private void createMap() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                this.map[i][j] = new Cell();
            }
        }
    }

    private void fillMapWithData() {
       int index = 0;
       while(true) {
            int randNum = (int) Math.round(Math.random() * 8) + 1;

            int row = (int) Math.floor(index / 9);
            int col = index % 9;
            boolean rulesNotBroken = true;

            if(index == 81)
                break;

            if(this.numGenerator.getNumTestedSize(index) == 9) {
                this.numGenerator.clearSpecificNumTestedList(index);
                this.map[row][col].setValue(0);
                index--;
                continue;
            }
            else if(this.numGenerator.checkIfNumExistsInList(randNum, index)) {
                continue;
            }
            else {
                this.numGenerator.setNumTestedToGenerator(randNum, index);
            }

            if(!this.checkHorizontalLineIfNumberValid(row, col, randNum))
                rulesNotBroken = false;
            if(!this.checkVerticalLineIfNumberValid(row, col, randNum))
                rulesNotBroken = false;
            if(!this.checkThreeByThreeGridValidation(row, col, randNum))
                rulesNotBroken = false;

            if(rulesNotBroken) {
                this.map[row][col].setValue(randNum);
                this.solvedMap[row][col] = randNum;
                index++;
            } 
       }
       this.removeRandomCellsValue();
       
    }

    private void storeFreeCellsCoordinates(int x, int y) {
        int[] coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;

        this.freeCellCoordinates.add(coordinates);
    }

    private void removeRandomCellsValue() {
        // wipe some random cells to make the game playable
       for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(Math.round(Math.random() * 3) == 2 || Math.round(Math.random() * 3) == 1) {
                    this.map[i][j].setValue(0);
                    this.storeFreeCellsCoordinates(i, j);
                }
            }
        }
    }
    
    public boolean checkIfSudokuIsSolved() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(this.map[i][j].getValue() != this.solvedMap[i][j])
                    return false;
            }
        }

        return true;
    }

    public boolean checkIfCoordsAreNotFromDefaultMap(int x, int y) {
        for (int[] freeCellCoordinatesElem : this.freeCellCoordinates) {
            if(freeCellCoordinatesElem[0] == x && freeCellCoordinatesElem[1] == y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontalLineIfNumberValid(int x, int y, int number) {
        for(int j = 0; j < 9; j++) {
            if(j != y && this.map[x][j].getValue() == number)
                return false;
        }
        return true;
    }

    public boolean checkVerticalLineIfNumberValid(int x, int y, int number) {
        for(int i = 0; i < 9; i++) {
            if(i != x && this.map[i][y].getValue() == number)
                return false;
        }
        return true;
    }

    public boolean checkThreeByThreeGridValidation(int x, int y, int number) {
        for(int i = x - (x % 3); i < x - (x % 3) + 3; i++) {
            for(int j = y - (y % 3); j < y - (y % 3) + 3; j++) {
                if(this.map[i][j].getValue() == number && i != x && j != y) 
                    return false;
            }
        }
        return true;
    }

    public void setCellValue(int x, int y, int number) {
        this.map[x][y].setValue(number);
    }
    
    public void printMap() {
        System.out.print("  ");
        for(int i = 0; i < 9; i++) {
            System.out.print(" " + (i + 1) + " ");
        }
        for(int i = 0; i < 9; i++) {
            System.out.println("\n  ---------------------------");
            System.out.print((i + 1) + " ");
            for(int j = 0; j < 9; j++) {
                this.map[i][j].draw();
            }
        }
        System.out.println("\n  ---------------------------");
    }
}
