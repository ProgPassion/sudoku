package helloworld;

public class Hello {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Map map = new Map();
		Input input = new Input(map);
        map.printMap();
        input.getCoordinates();
	}
} 