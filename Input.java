package helloworld;

import java.util.Scanner;

public class Input {
    private int x;
    private int y;
    private int number;
    private Map map;

    public Input(Map map) {
        this.map = map.getMap();
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
        for(int i = 0; i < 9; i++) {
            if(this.map[i][y].getValue() == number)
                return false;
        }                
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

            this.x = Integer.parseInt(coordinates[0]);
            this.y = Integer.parseInt(coordinates[1]);

            if((this.x >= 1 && this.x <= 9) && (this.y >= 1 && this.y <= 9)) 
                break;
        } while(true);
        scan.close();
        System.out.println("Input was: " + coordinates[0] + "," + coordinates[1]);  
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


        } while(true);
        scan.close();
    }
}
