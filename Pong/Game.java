package Pong;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet1 = new Racquet(this, 60);
	Racquet racquet2 = new Racquet(this, 330);
	int speed = 1;
	public static final int WIDTH = 350;
	public static final int HEIGHT = 430;
	int scorePlayer1 = 0;
	int scorePlayer2 = 0;
	boolean ballStopped = false;
	byte whoScored = 0;

	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
					racquet1.xa = 0;
				}
				else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
					racquet2.xa = 0;
				}
			}

			// determines what keys are pressed and their effects to racquets when pressed
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_A) {
					racquet1.xa = -speed;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					racquet1.xa = speed;			
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					racquet2.xa = -speed;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					racquet2.xa = speed;
				}
			}
		});
		setFocusable(true);
		Sound.BACK.loop();
	}
	// moves the sprites
	private void move() throws InterruptedException {
		ball.move();
		racquet1.move();
		racquet2.move();
	}

	// sprites are created
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// Mga char char ug echos nga design (not really important)
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, WIDTH, 55);
		g.setColor(Color.RED);
		g.fillRect(0, 345, WIDTH, 55);
		g.setColor(Color.GREEN);
		g.fillRect(0, 55, WIDTH, HEIGHT - 140);
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(0, (HEIGHT/2) - 10, WIDTH, (HEIGHT/2 - 10));
		
		// for the sprites
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		ball.paint(g2d);
		g2d.setColor(Color.BLUE);
		racquet1.paint(g2d);
		g2d.setColor(Color.RED);
		racquet2.paint(g2d);

		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));
		
		// Shows the scores of each player
		g2d.drawString(String.valueOf(scorePlayer1), 10, 30);
		g2d.drawString(String.valueOf(scorePlayer2), WIDTH - 30, HEIGHT - 50);
		

		
		if(scorePlayer1 == 3 || scorePlayer2 == 3) {
			ball.xa = 0;
			ball.ya = 0;
			ballStopped = true;
		}
		
	}

	// stops the game and then prompts user to rematch if yes is pressed, otherwise closes the program
	public void gameOver() throws InterruptedException {
			String winner = "";
			if(scorePlayer1 == 3) {
				winner = "BLUE";
			}
			else if(scorePlayer2 == 3) {
				winner = "RED";
			}
			JOptionPane.showMessageDialog(this,winner + " wins!", "We Have a Winner!", JOptionPane.YES_NO_OPTION);
			
			if(JOptionPane.showConfirmDialog(this,"REMACTCH", "Game Over", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
				Sound.BACK.stop();
				System.exit(ABORT);	
			}

			else {
				// If the user wants rematch
				resetEverything();
				newRound();
			}
	}
	
	// If the user wants rematch, reset the score and everything back to the beginning
	public void resetEverything() {
		ball.xa = 1;
		ball.ya = 1;
		scorePlayer1 = 0;
		scorePlayer2 = 0;
		ballStopped = false;
	}
	
	// Called when a player gets one point
	public void newRound() throws InterruptedException {
		ball.accelerateBall = 1;
		ball.xa = 1;
		ball.ya = 1;
		speed = 1;
		ball.x = 150;
//		ball.y = 190;
		racquet1.x = 120;
		racquet2.x = 120;
		if (whoScored == 1) {
			scorePlayer1 = scorePlayer1 + 1;
			ball.y = racquet1.surfaceY();
			whoScored = 0;
		}
		else if(whoScored == 2) {
			scorePlayer2 = scorePlayer2 + 1;
			ball.y = racquet2.surfaceY() - (ball.DIAMETER - 5);
			whoScored = 0;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Pong");
		frame.setResizable(false);
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		// Para sa center moset ang frame. (Googled it!)
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2-frame.getSize().height / 2);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JOptionPane.showMessageDialog(game,"___________________________\n"
				+ "+====   PONG : Two Player  ====+\n"
				+ "===========================\n"
				+ "GAME CONTROLS:\n"
				+ "===========================\n"
				+ "> BLUE Player use A/D Keys\n"
				+ "> RED Player use Left/Right \n   arrowkeys\n"
				+ "> The first to get 3 points \n   is the WINNER!\n"
				+ "Simple as that. Enjoy!\n"
				+ "===========================\n", "HELLO! ", JOptionPane.YES_NO_OPTION);
		Thread.sleep(2500);		// Para dili ma shock ang players/ Gives them time to prepare.
		while (true) {
			game.move();
			game.repaint(); // to refresh the location of the object
			Thread.sleep(10);
		}
	}
}
