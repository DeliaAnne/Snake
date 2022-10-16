package game;

public class Board {
	int[][] board;
	int boardSize;
	boolean end;
	Pair food;
	Pair head;
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
		this.head = this.snake.getHead();
		placeFood();
	}
	
	public void move(int dir) {
		Pair temp = this.snake.getHead();
		//Pair temp = this.head;
		Pair last = this.snake.getTail();
		int x = temp.getX();
		int y = temp.getY();
		if(dir == UP) {
			if(y-1>=0) {
				//System.out.println("UP");
				y--;
			}else {
				this.end = true;
			}
		}else if(dir == DOWN) {
			if(y+1<this.boardSize) {
				y++;
			}else {
				this.end = true;
			}
		}else if(dir == RIGHT) {
			if(x+1<this.boardSize) {
				x++;
			}else {
				this.end = true;
			}
		}else if(dir == LEFT){
			if(x-1>=0) {
				x--;
			}else {
				this.end = true;
			}
		}
		//move head
		temp = new Pair(x,y);
		//if food, just grow else move tail
		if(this.snake.snake.contains(temp)){
			this.end = true;
			
		}else if(board[y][x] == 2) {
			board[y][x] = 1;
			placeFood();
			this.snake.snake.addFirst(temp);
		}else {
			board[last.getY()][last.getX()] = 0;
			board[y][x] = 1;
			this.head = temp;
			this.snake.snake.addFirst(temp);
			this.snake.snake.removeLast();
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
