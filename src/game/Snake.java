package game;

import java.util.ArrayDeque;

public class Snake {
	ArrayDeque<Pair> snake;

	
	public Snake(){
		this.snake = new ArrayDeque<Pair>();
	}
	
	public void move(Pair newHd) {
		snake.addFirst(newHd);
		snake.removeLast();
	}
	
	public Pair getHead() {
		return snake.getFirst();
	}
	
	//this is useful for my test
	public Pair getTail() {
		return snake.getLast();
	}
	
	public void grow(Pair hd) {
		snake.addFirst(hd);
	}
	
	public int getSize() {
		return this.snake.size();
	}
	
}
