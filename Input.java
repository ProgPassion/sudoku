import java.util.Scanner;

public class Input {
    private int x;
    private int y;
    private int number;
    private Map map;

    public Input(Map map) {
        this.map = map;
    }

    private boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    
    private boolean checkIfInputNumberIsAllowed(int number) {
        if(!this.map.checkHorizontalLineIfNumberValid(this.x, this.y, this.number))  
            return false;
        if(!this.map.checkVerticalLineIfNumberValid(this.x, this.y, this.number))
            return false;
        if(!this.map.checkThreeByThreeGridValidation(this.x, this.y, this.number))
            return false;

        return true;
    }

    public void getCoordinates() {
        String input;
        String[] coordinates = new String[2];
        Scanner scan;
        do {
            System.out.print("\n\nEnter the coordinates of the cell you want to write in (for e.g 0,0): ");
            scan = new Scanner(System.in);
            
            input = scan.nextLine();
            coordinates = input.split(",");
            if(coordinates.length != 2)
                continue;

            if(!this.isNumber(coordinates[0]) || !this.isNumber(coordinates[1])) 
                continue;   

            this.x = Integer.parseInt(coordinates[0]) - 1;
            this.y = Integer.parseInt(coordinates[1]) - 1;

            if(!(this.x >= 0 && this.x <= 8) && (this.y >= 0 && this.y <= 8)) {
                System.out.println("The coordinate numbers must be from the range 1-9!");
                continue;
            }

            if(this.map.checkIfCoordsAreNotFromDefaultMap(this.x, this.y)) {
                break;
            }
            else {
                System.out.println("You are not allowed to override the map default cells");
            }
                
        } while(true);
    }

    public void getNumber() {
        String inputNum;
        Scanner scan;
        do {
            System.out.print("Enter a number from 1-9:");
            scan = new Scanner(System.in);

            inputNum = scan.nextLine();
            if(!this.isNumber(inputNum))
                continue;
            
            this.number = Integer.parseInt(inputNum);

            if(this.number < 1 || this.number > 9)
                continue;

            if(this.checkIfInputNumberIsAllowed(this.number)) {
                map.setCellValue(this.x, this.y, this.number);
                break;
            }
            

        } while(true);
    }
}
