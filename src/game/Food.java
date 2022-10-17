package game;

public class Food {
	
	static Pair generateFood(int boardSize) {
		int x = (int) (Math.random() *boardSize-1);
		int y = (int) (Math.random() *boardSize-1);

		return new Pair(x,y);
	}

}
