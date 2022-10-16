package game;

public class Board {
	int[][] board;
	int boardSize;
	boolean end;
	Pair food;
	Snake snake;
	
	public final int UP = 0;
	public final int DOWN = 1;
	public final int RIGHT = 2;
	public final int LEFT = 3;
	
	public Board(int sz) {
		this.boardSize = sz;
		this.board = new int[sz][sz];
		this.end = false;
		this.snake = new Snake();
		placeSnake();
	}
	
	public void placeSnake() {
		//start in the middle of the board
		int start = (boardSize)/2; //4
		int end = start-3; // 1
		for(int i =end; i<start; i++) {
			System.out.println(start+", "+end);
			board[start][i] = 1;
			this.snake.grow(new Pair(start,i));
		}
		placeFood();
	}
	
	public void move(int dir) {
		Pair first = this.snake.snake.getFirst();
		Pair last = this.snake.snake.getLast();
		Pair temp = first;
		int x = first.getX();
		int y = first.getY();
		if(dir == UP) {
			if(y-1>=0) {
				//System.out.println("UP");
				y--;
			}else {
				System.out.println("Hit boundary U");
				this.end = true;
			}
		}else if(dir == DOWN) {
			if(y+1<this.boardSize) {
				y++;
			}else {
				System.out.println("Hit boundary D");
				this.end = true;
			}
		}else if(dir == RIGHT) {
			if(x+1<this.boardSize) {
				//System.out.println("right");
				x++;
			}else {
				System.out.println("Hit boundary R");
				this.end = true;
			}
		}else if(dir == LEFT){
			if(x-1>=0) {
				//System.out.println("left");
				x--;
			}else {
				System.out.println("Hit boundary L");
				this.end = true;
			}
		}
		//move head
		temp = new Pair(x,y);
		//if food, just grow else move tail
		if(board[y][x] == 1){
			System.out.println("Hit snake "+first.getX()+" "+first.getY());
			System.out.println("Hit snake "+this.snake.getHead().getX()+" "+this.snake.getHead().getY());
			System.out.println("Hit snake "+x+" "+y);
			for(Pair each: this.snake.snake) {
				System.out.print(each.getX()+" "+each.getY()+", ");
			}
			this.end = true;
			
		}else if(board[y][x] == 2) {
			this.snake.snake.addFirst(temp);
			board[y][x] = 1;
			placeFood();
		}else {
			this.snake.snake.addFirst(temp);
			this.snake.snake.removeLast();
			board[last.getY()][last.getX()] = 0;
			board[y][x] = 1;
		}
	}
	
	public boolean isEnd() {
		return this.end;
	}
	
	public void placeFood() {
		food = Food.generateFood(boardSize, board);
		board[food.getY()][food.getX()] = 2;
	}
}
