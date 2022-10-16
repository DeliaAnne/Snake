package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics extends JPanel implements ActionListener{

	private Timer t = new Timer(100, this);
	private String state;
	
	private Snake s;
	private Board board;
	private Game game;
	
	
	public Graphics(Game g) {
		this.state = "START";
		this.t.start();
		this.game = g;
		this.s = g.snake;
		this.board = g.board;
		
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);
		
		g2d.setColor(Color.GREEN); //my snake is for sure vegan. Fruits and veggies only
		g2d.fillRect(board.food.getX()*Game.dimension, board.food.getY()*Game.dimension, Game.dimension, Game.dimension);
		
		g2d.setColor(Color.CYAN); 
		for(Pair each : s.snake) {
			g2d.fillRect(each.getX()*Game.dimension, each.getY()*Game.dimension, Game.dimension, Game.dimension);
		}
		
		if(state.equals("START")) {
			state = "RUNNING";
		}
		if(board.isEnd()){
			System.out.println("end");
			//end game
			this.state = "END";
			t.stop();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.state = "RUNNING";
		this.board.move(this.game.getDir());
		repaint();
	}

}
