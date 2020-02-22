package source;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final Rectangle windowSize = new Rectangle(616, 760);
	private final JLabel gameTitle = new JLabel();
	private JPanel startMenu;
	private JPanel levelMenu;
	private JPanel buttonPanel;
	private Board board;
	private JPanel ingamePanel;
	private final JButton playButton = new JButton("Play");
	private final JButton lv1Button = new JButton("Level 1");
	private final JButton lv2Button = new JButton("Level 2");
	private final JButton lv3Button = new JButton("Level 3");
	private final JButton returnToLvMenuButton = new JButton("Menu");
	private final JButton restartLvButton = new JButton("Restart");
	private String currentLevel;
	

	public Application() {
		initUI();
	}

	private void initUI() {
		initStartMenu();
		add(startMenu);
		setResizable(false);
		setSize(windowSize.getSize());
		setTitle("Cookie Trail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void initStartMenu() {
		try {
			final BufferedImage image = ImageIO
					.read(new File(".\\src\\resource\\gameTitle.png"));
			gameTitle.setIcon(new ImageIcon(image));
		} catch (final IOException e) {
			e.printStackTrace();
		}
		startMenu = new JPanel(new BorderLayout());
		startMenu.setBounds(windowSize);
		startMenu.add(gameTitle, BorderLayout.CENTER);
		startMenu.add(playButton, BorderLayout.PAGE_END);
		startMenu.setBackground(Color.WHITE);
		playButton.addActionListener(new PlayAction());

		add(startMenu);
	
	}

	private void initLevelMenu() {
		levelMenu = new JPanel(new GridLayout(0, 3, 1, 1));
		levelMenu.setBounds(windowSize);
		levelMenu.add(lv1Button);
		levelMenu.add(lv2Button);
		levelMenu.add(lv3Button);
		lv1Button.addActionListener(new Lv1Action());
		lv2Button.addActionListener(new Lv2Action());
		lv3Button.addActionListener(new Lv3Action());

		add(levelMenu);
		
	}

	private void initIngameUI() {
		board = new Board();

		buttonPanel = new JPanel(new GridLayout(0,3,1,1));
		buttonPanel.add(returnToLvMenuButton);
		buttonPanel.add(restartLvButton);

		ingamePanel = new JPanel(new BorderLayout());
		ingamePanel.setBounds(windowSize);
		ingamePanel.add(board, BorderLayout.CENTER);
		ingamePanel.add(buttonPanel, BorderLayout.PAGE_END);
		
		returnToLvMenuButton.addActionListener(new ReturnAction());
		restartLvButton.addActionListener(new RestartAction());

		add(ingamePanel);
		
	}

	private class PlayAction implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("Play button pressed!");
			remove(startMenu);
			initLevelMenu();
			validate();
		}

	}

	private class Lv1Action implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("Level 1 button pressed!");
			remove(levelMenu);
			initIngameUI();
			board.setBoard("1");
			currentLevel = "1";
			// ingamePanel.add(board.monsterLabel);
			// for(JLabel l : board.cherriesLabel) {
			// 	ingamePanel.add(l);
			// }
			validate();
		}

	}

	private class Lv2Action implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("Level 2 button pressed!");
			remove(levelMenu);
			initIngameUI();
			board.setBoard("2");
			currentLevel = "2";
			// ingamePanel.add(board.monsterLabel);
			// for(JLabel l : board.cherriesLabel) {
			// 	ingamePanel.add(l);
			// }
			validate();
		}

	}

	private class Lv3Action implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent e) {
			System.out.println("Level 3 button pressed!");
			remove(levelMenu);
			initIngameUI();
			board.setBoard("3");
			currentLevel = "3";
			// ingamePanel.add(board.monsterLabel);
			// for(JLabel l : board.cherriesLabel) {
			// 	ingamePanel.add(l);
			// }
			validate();
		}
	
	}

	private class ReturnAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			board.clearBoard();
			remove(ingamePanel);
			add(levelMenu);
			levelMenu.repaint();
			validate();

		}
		
	}

	private class RestartAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			board.clearBoard();
			board.setBoard(currentLevel);
			board.repaint();
			validate();

		}
		
	}

}
