package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game implements KeyListener{
	
	public Snake snake;
	public Board board;
	public JFrame window;
	public Graphics graphics;
	
	int dir=2;
	
	public static final int width = 30;
	public static final int height = 30;
	public static final int dimension = 20;
	
	public Game() {
		this.board = new Board(width);
		this.snake = this.board.snake;
		this.window = new JFrame();
		this.graphics = new Graphics(this);
		
		
		window.add(graphics);
		window.setTitle("Snake");
		window.setSize(width*dimension+ dimension, height*dimension + dimension);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public int getDir() {
		return this.dir;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_DOWN) {
			this.dir = board.DOWN;
		}else if(key == KeyEvent.VK_UP) {
			this.dir = board.UP;
		}else if(key == KeyEvent.VK_RIGHT) {
			this.dir = board.RIGHT;
		}else if(key == KeyEvent.VK_LEFT) {
			this.dir = board.LEFT;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
