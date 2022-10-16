package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class SnakeTest {

	@Test
	public void snakeTest() {
		Snake sn = new Snake();
		assert sn.getSize() == 0;
	}
	
	@Test
	public void growTest() {
		Snake sn = new Snake();
		sn.grow(new Pair(0,0));
		sn.grow(new Pair(0,1));
		System.out.println(sn.getSize());
		assert(sn.getSize() == 2);
		assert(sn.getHead().getX() == 1);
	}

	@Test
	public void moveTest() {
		Snake sn = new Snake();
		sn.grow(new Pair(0,0));
		sn.grow(new Pair(0,1));
		sn.grow(new Pair(0,2));
		sn.move(new Pair(1,2));
		assert(sn.getHead().getX() == 2);
		assert(sn.getHead().getY() == 1);
		assert(sn.getSize() == 3);
		assert(sn.getTail().getX() == 1);
	}
	
}
