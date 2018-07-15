import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	public static final int CELLS_PER_ROW = 128;
	
	public boolean isRunning = false;
	
	public static boolean CRT = true;

	private JFrame window;
	private JPanel inputPanel;
	
	private JButton clearButton;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JLabel speedLabel;
	private JLabel LB;

	private JTextField speedField;
	private JTextField prbField;

	private JTextField probField;

	private JButton NYAN;
	
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {		

		window = new JFrame();
		inputPanel = new JPanel();
		gamePanel = new WorldPanel(WIDTH,HEIGHT,CELLS_PER_ROW);
		startStopButton = new JButton("start");
		NYAN = new JButton("NYAN-ON");
		NYAN.addActionListener(this);
		startStopButton.addActionListener(this);
		randomizeButton = new JButton("mIX");
		clearButton = new JButton();
		clearButton.setText("clear");
		clearButton.addActionListener(this);
		speedLabel = new JLabel();
		LB = new JLabel("/");

		speedLabel.setText("speed");
		speedField = new JTextField("16");
		prbField = new JTextField("5");

		probField = new JTextField("1");

		speedField.setText("" + gamePanel.getTimer());
		randomizeButton.addActionListener(this);
		window.setDefaultCloseOperation(3);	
		window.add(inputPanel);
		window.setVisible(true);
		window.setBounds(0, 0, 1000, 1000);
		
		inputPanel.add(startStopButton);
		inputPanel.add(speedLabel);
		
		inputPanel.add(speedField);
		inputPanel.add(NYAN);
		inputPanel.add(probField);
		inputPanel.add(LB);

		inputPanel.add(prbField);
		inputPanel.add(randomizeButton);
		inputPanel.add(clearButton);
		inputPanel.add(gamePanel);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == NYAN) {
			if(CRT) {
				CRT = false;
				NYAN.setText("NYAN-OFF");
			}else {
				CRT = true;
				NYAN.setText("NYAN-ON");
			}
		}
		if(e.getSource() == startStopButton) {
			if(isRunning == false) {
				isRunning = !isRunning;
				startStopButton.setText("stop");
				gamePanel.startAnimation(Integer.parseInt(speedField.getText()));
			} else if(isRunning == true) {
				isRunning = !isRunning;
				startStopButton.setText("start");
				gamePanel.stopAnimation(Integer.parseInt(speedField.getText()));
			}
		}
		if(e.getSource() == randomizeButton) {
			gamePanel.randomizeCells(Integer.parseInt(prbField.getText()),Integer.parseInt(probField.getText()));
		}
		if(e.getSource() == clearButton) {
			gamePanel.clearCells();
		}
	}
	}