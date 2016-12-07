package Pong;


import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet {
	private static final int WITH = 100;
	private static final int HEIGHT = 10;
	private int y;
	int x = 120;
	int xa = 0;
	private Game game;

	public Racquet(Game game, int y) {
		this.game = game;
		this.y = y;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}

	// creates the racquet sprites
	public void paint(Graphics2D g) {
		g.fillRect(x, y, WITH, HEIGHT);
	}

//	public void keyReleased(KeyEvent e) {
//		
//	}
//
//	public void keyPressed(KeyEvent e) {
//		
//	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, WITH, HEIGHT);
	}

	public int surfaceY() {
		if (y == 60) {
			return y + HEIGHT;
		}
		else {
			return y - HEIGHT;
		}
	}
}