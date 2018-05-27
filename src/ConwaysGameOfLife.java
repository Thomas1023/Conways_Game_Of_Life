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

/*
 *  1. Check out the Wikipedia page on Conway's Game of Life to familiarize yourself
 *     with the concept.
 *     
 *	https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 */

/*
 *  2. Run the ConwaysGOL.jar to see a demo of the final product.
 */

/* 
 *  3. Create the program on your own or fill in the code under the comments to complete the project.
 *
 */

public class ConwaysGameOfLife extends JPanel implements ActionListener{
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static final int CELLS_PER_ROW = 350;
	
	private boolean isRunning = false;
	
	private JFrame window;
	private JPanel inputPanel;
	private JButton startStopButton;
	private JButton randomizeButton;
	private JButton clearButton;
	private JLabel speedLabel;
	private JTextField speedField;
	
	private WorldPanel gamePanel;
	
	public static void main(String[] args) {
		new ConwaysGameOfLife().launchGame();
	}
	
	public void launchGame() {
		//build the window and start the simulation
		window = new JFrame();
		startStopButton = new JButton();
		randomizeButton = new JButton();
		clearButton = new JButton();
		window.setVisible(true);
		window.setSize(800, 800);
		window.setTitle("Kanye's Game Of Life");
		window.add(inputPa)
		window.add(startStopButton);
		window.add(randomizeButton);
		window.add(clearButton);
		window.add();
		
	}
	
	@Override
	public void (ActionEvent e) {
		//if startStopButton is pressed, 
			// toggle isRunning to the opposite of its current state
			// start or stop the animation based on the state of isRunning
		
		// if ranomizeButton is pressed
			// call randomizeCells
		
		// if clearButton is pressed
			//call clearCells
	}
	}

