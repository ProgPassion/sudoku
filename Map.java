package helloworld;
public class Map {
    
    private Cell[][] map;
    
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
