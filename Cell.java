public class Cell {

    private int value = 0;

    public int getValue() {
        return this.value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    public void draw() {
        if(value == 0) 
            System.out.print("| |");
        else
            System.out.print("|" + value + "|");
    }
}
