package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Game extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label label;
	private CheckboxGroup choices;
	private Checkbox rock;
	private Checkbox paper;
	private Checkbox scissors;
	private Checkbox lizard;
	private Checkbox spock;
	private TextArea textArea;
	private Button btnGame;
	private Label player;
	private TextField playerScore;
	private Label computer;
	private TextField compScore;
	private Dialog gameOver;
	private Random random;
	private int choice = 0;
	private int scorePl = 0;;
	private int scoreCp = 0;;

	public Game() {
		setLayout(new FlowLayout());
		label = new Label("Your Choice:");
		choices = new CheckboxGroup();
		rock = new Checkbox("Rock", false, choices);
		paper = new Checkbox("Paper", false, choices);
		scissors = new Checkbox("Scissors", false, choices);
		lizard = new Checkbox("Lizard", false, choices);
		spock = new Checkbox("Spock", false, choices);
		textArea = new TextArea("Results:\n");
		btnGame = new Button("RockPaperScissorsLizardsSpock");
		player = new Label("Player's Score");
		playerScore = new TextField(String.format("%d", scorePl));
		computer = new Label("Computer's Score");
		compScore = new TextField(String.format("%d", scoreCp));
		gameOver = new Dialog(gameOver, "Game Over!", false);

		btnGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String rocks = "ROCK.\n";
				String papers = "PAPER.\n";
				String scissorsz = "SCISSORS.\n";
				String lizards = "LIZZARD.\n";
				String spocks = "SPOCK.\n";
				textArea.append("Player chose ");
				if (rock.getState() == true) {
					textArea.append(rocks);
					choice = 1;
				}
				if (paper.getState() == true) {
					textArea.append(papers);
					choice = 2;
				}
				if (scissors.getState() == true) {
					textArea.append(scissorsz);
					choice = 3;
				}
				if (lizard.getState() == true) {
					textArea.append(lizards);
					choice = 4;
				}
				if (spock.getState() == true) {
					textArea.append(spocks);
					choice = 5;
				}
				// If there is no active radio button
				if (rock.getState() == false && paper.getState() == false && spock.getState() == false
						&& lizard.getState() == false && scissors.getState() == false) {
					textArea.append("NOTHING.\n");
				}
				textArea.append("Computer chose ");
				int computer = computerRandom();
				if (computer == 1) {
					textArea.append(rocks);
				}
				if (computer == 2) {
					textArea.append(papers);
				}
				if (computer == 3) {
					textArea.append(scissorsz);
				}
				if (computer == 4) {
					textArea.append(lizards);
				}
				if (computer == 5) {
					textArea.append(spocks);
				}

				if (choice == computer) {
					textArea.append("DRAW!\n");
				}

				// Decide who is the winner
				/*
				 * LEGEND: Rock = 1 : defeats: 3, 4 Paper = 2 : defeats: 1, 5
				 * Scissors = 3 : defeats: 2, 4 Lizard = 4 : defeats: 2, 5 Spock
				 * = 5 : defeats: 1, 3
				 * 
				 */
				if (choice == 1) {
					if (computer == 3 || computer == 4) {
						textArea.append("Player got 1 point!\n");
						scorePl += 1;
						playerScore.setText(String.format("%d", scorePl));
					} else if (computer == 2 || computer == 5) {
						textArea.append("Computer got 1 point!\n");
						scoreCp += 1;
						compScore.setText(String.format("%d", scoreCp));
					}
				}
				if (choice == 2) {
					if (computer == 1 || computer == 5) {
						textArea.append("Player got 1 point!\n");
						scorePl += 1;
						playerScore.setText(String.format("%d", scorePl));
					} else if (computer == 3 || computer == 4) {
						textArea.append("Computer got 1 point!\n");
						scoreCp += 1;
						compScore.setText(String.format("%d", scoreCp));
					}

				}
				if (choice == 3) {
					if (computer == 2 || computer == 4) {
						textArea.append("Player got 1 point!\n");
						scorePl += 1;
						playerScore.setText(String.format("%d", scorePl));
					} else if (computer == 1 || computer == 5) {
						textArea.append("Computer got 1 point!\n");
						scoreCp += 1;
						compScore.setText(String.format("%d", scoreCp));
					}

				}
				if (choice == 4) {
					if (computer == 2 || computer == 5) {
						textArea.append("Player got 1 point!\n");
						scorePl += 1;
						playerScore.setText(String.format("%d", scorePl));
					} else if (computer == 1 || computer == 3) {
						textArea.append("Computer got 1 point!\n");
						scoreCp += 1;
						compScore.setText(String.format("%d", scoreCp));
					}

				}
				if (choice == 5) {
					if (computer == 1 || computer == 3) {
						textArea.append("Player got 1 point!\n");
						scorePl += 1;
						playerScore.setText(String.format("%d", scorePl));
					} else if (computer == 2 || computer == 4) {
						textArea.append("Computer got 1 point!\n");
						scoreCp += 1;
						compScore.setText(String.format("%d", scoreCp));
					}

				}

				// The first player who gets 5 points is the winner.
				if (scorePl == 5 || scoreCp == 5) {
					final Button ok = new Button("OK");
					String winner = "";
					if (scorePl == 5) {
						winner = "Player wins!\n";
					}
					if (scoreCp == 5) {
						winner = "Computer wins!\n";
					}
					final Label win = new Label(winner);

					// PopUp Window
					playerScore.setText(String.format("%d", scorePl));
					compScore.setText(String.format("%d", scoreCp));
					gameOver.setBounds(100, 50, 250, 150);
					gameOver.setLayout(new FlowLayout());
					gameOver.add(win);
					ok.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							gameOver.setVisible(false);
							resetScore();
							// Para dili mag overlap ang buttons
							gameOver.remove(win);
							gameOver.remove(ok);
						}
					});
					gameOver.add(ok);
					gameOver.setVisible(true);
					gameOver.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							gameOver.setVisible(false);
							resetScore();
							gameOver.remove(win);
							gameOver.remove(ok);
						}
					});
				}
			}
		});

		add(label);
		add(rock);
		add(paper);
		add(scissors);
		add(lizard);
		add(spock);
		add(textArea);
		add(btnGame);
		add(player);
		add(playerScore);
		add(computer);
		add(compScore);

		setTitle("Game");
		setSize(510, 300);
		setVisible(true);

		// Window Closing
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		this.random = new Random();
	}

	// Resets the score to zero after having a winner.
	public void resetScore() {
		scorePl = 0;
		scoreCp = 0;
		playerScore.setText(String.format("%d", scorePl));
		compScore.setText(String.format("%d", scoreCp));
		textArea.setText("Results: \n");
	}

	// Generates random choice for computer player
	public int computerRandom() {
		int randomNum = random.nextInt((5 - 1) + 1) + 1;
		return randomNum;
	}

	public static void main(String[] args) {
		new Game();
	}

}
