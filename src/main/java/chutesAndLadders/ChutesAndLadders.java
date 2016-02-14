package chutesAndLadders;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ChutesAndLadders extends JFrame {

	private JButton spinButton;
	private String[] photos;
	private Board board;
	private PlayTheGame logic;

	// private ActionListener buttonListen;

	public ChutesAndLadders(String playerOneName, String PlayerTwoName) {

		setTitle("CHUTES AND LADDERS");
		setSize(1100, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		BorderLayout bLayout = new BorderLayout();
		setLayout(bLayout);

		board = new Board();
		add(board, BorderLayout.CENTER);

		board = new Board();
		add(board, BorderLayout.CENTER);

		spinButton = new JButton();
		spinButton.setIcon(new ImageIcon("ROLL.png"));
		spinButton.addActionListener(buttonListen);
		photos = new String[] { "#1.png", "#2.png", "#3.png", "#4.png",
				"#5.png", "#6.png" };

		add(spinButton, BorderLayout.LINE_START);

		logic = new PlayTheGame(new Player(playerOneName, 1), new Player(
				PlayerTwoName, 2));
	}

	ActionListener buttonListen = new ActionListener() {

		public void actionPerformed(ActionEvent event) {

			int value = logic.rollDice();
			spinButton.setIcon(new ImageIcon(photos[value - 1]));
			logic.turn(value);
			board.setIconPieces(logic.getCurrent().getPosition().getRow(),
					logic.getCurrent().getPosition().getCol());
		}
	};

	public int rollDice() {
		Random random = new Random();
		int val = random.nextInt(6) + 1;
		return val;

	}

}
