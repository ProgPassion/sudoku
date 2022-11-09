package helloworld;

public class App {
	
	public static void main(String[] args) {
		 Map map = new Map();
		 Input input = new Input(map);

		 while(!map.checkIfSudokuIsSolved()) {
	    	 	map.printMap();
	    		input.getCoordinates();
	    		input.getNumber();    
		 }
		 map.printMap();
		 System.out.println("Congratulations! You solved the sudoku... :)");
	}
} 
