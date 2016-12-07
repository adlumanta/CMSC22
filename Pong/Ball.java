package Pong;


import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	final int DIAMETER = 30;
	private static final int UPPERBOUND = 55;
	private static final int LOWERBOUND = 345;
	int x = 160 - DIAMETER;		// 	initial ball position
	int y = 210 - DIAMETER;		// 	initial ball position
	int xa = 1;					//	ball speed
	int ya = 1;					//	ball speed
	private Game game;
	int accelerateBall = 1;		// initial counter, will speed up ball if reaches 4

	public Ball(Game game) {
		this.game = game;
	}

	// moves the ball
	void move() throws InterruptedException {
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		
		else if ((y + ya < UPPERBOUND) || (y + ya > LOWERBOUND - DIAMETER)) {  // If ball misses racquet.
			if(y + ya < UPPERBOUND) {		// If player1 misses the ball.
				game.whoScored = 2;
			}
			if(y + ya > LOWERBOUND - DIAMETER) {	//If player 2 misses the ball.
				game.whoScored = 1;
			}
			Sound.GAMEOVER.play();
			Thread.sleep(2000);
			game.newRound();		// New Round if nobody has won yet.
		}
		// If ball hits any racquet
		else if (collisionRacquet1() || collisionRacquet2()){
			if(collisionRacquet1()) {
				ya = game.speed;
			}
			if(collisionRacquet2()) {
				ya = -game.speed;
				y = game.racquet2.surfaceY() - DIAMETER;
			}
			accelerateBall++;
			if(accelerateBall == 4) {
				accelerateBall = 0;
				game.speed += 1;
			}
		}
		else {
			changeDirection = false;
		}
		
		if (changeDirection) 
			Sound.BALL.play();
			x = x + xa;
			y = y + ya;
		if (game.ballStopped == true) {
			game.gameOver();
		}
	}

	public boolean collisionRacquet1() {
		return game.racquet1.getBounds().intersects(getBounds());
	}
	
	public boolean collisionRacquet2() {
		return game.racquet2.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}