package helloworld;
public class Map {
    
    private Cell[][] map;
    private int[][] coordinatesWriten = new int[81][3];
    
    public Map() {
        this.map = new Cell[9][9];
        this.createMap();
    }

    private void createMap() {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                this.map[i][j] = new Cell();
            }
        }
    }
    
    private void fillMapWithData() {
        int[] rowPossibleVals = new int[9];
        int index = 0;
        for(int i = 9; i > 0; i--) {
            for(int j = 0; j < 9; j++) {
                for(int k = 0; k < 9; k++) {
                    if(this.map[j][k].getValue() == 0) {
                        rowPossibleVals[index] = k;
                        index++;
                    }
                }
                Math.round(Math.random() * index);
            }
        }
    }    

    public boolean checkHorizontalLineIfNumberValid(int x, int y, int number) {
        for(int j = 0; j < 9; j++) {
            if(j != y && this.map[x][j] == number)
                return false;
        }
        return true;
    }

    public boolean checkVerticalLineIfNumberValid(int x, int y, int number) {
        for(int i = 0; i < 9; i++) {
            if(i != x && this.map[i][y] == number)
                return false;
        }
        return true;
    }

     public boolean checkThreeByThreeGridValidation(int x, int y, int number) {
        for(int i = x - (x % 3); i < x + 3; i++) {
            for(int j = y - (y % 3); j < y + 3; j++) {
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
                this.cell[i][j].draw();
            }
        }
        System.out.println("\n  ---------------------------");
    }
}
