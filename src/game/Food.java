package game;

public class Food {
	
	static Pair generateFood(int boardSize, int[][] board) {
		int x = (int) (Math.random() *boardSize-1);
		int y = (int) (Math.random() *boardSize-1);
		if(board[y][x] == 1) {
			return generateFood(boardSize, board);
		}else {
			return new Pair(x,y);
		}
	}

}
