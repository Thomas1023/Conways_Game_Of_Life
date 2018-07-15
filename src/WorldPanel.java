import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private int cellsPerRow;
	private int cellSize;
	private Cell[][] cells;
	private Timer timer;
	
	public void reDraw() {
		
		for (int h = 0; h < cells.length; h++) {
			for (int i = 0; i < cells.length; i++) {
					cells[i][h].draw(getGraphics());
			}
		}
		}
		
	
	
	public int[][] stepperCell() {
		for (int h = 0; h < cells.length; h++) {
			for (int i = 0; i < cells.length; i++) {
				return 1,1;
			}
			}
		return null;
	}

	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		timer = new Timer(211, this);
		this.cellsPerRow = cpr;
		cellSize = w/cpr;
		cells = new Cell[cpr][cpr];
		for (int p = 0; p < cpr; p++) {
		for (int i = 0; i < cpr; i++) {
			cells[i][p] = new Cell(i*cellSize,p*cellSize,cellSize);
		}
		}
	}
	
	public void randomizeCells(int p,int h) {
		Random rand = new Random();
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {
				if(rand.nextInt(p)+1 <= h){
					cells[i][j].isAlive = true;
					cells[i][j].draw(getGraphics());
					
				} else {
					cells[i][j].isAlive = false;
				}

				
			}
			}
		reDraw();
	
		
		
	}
	public void rayTubes() {
		
	}
	public void clearCells() {
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {
				System.out.println("killed all cells");
					cells[i][j].isAlive = false;
					
			}
		}
		reDraw();
		
	}
	
	public void startAnimation(int i) {
		setAnimationDelay(i);

		timer.start();
	}
	
	public void stopAnimation(int i) {
		setAnimationDelay(i);

		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//iterate through the cells and draw them
	}
	
	//advances world one step
	public void step() {
		//initialize the numLivingNbors variable to be the same size as the cells
		int[][] numLivingNbors = new int[cells[0].length][cells[0].length];
		
		//iterate through the cells and populate the numLivingNbors array with their neighbors
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {
					numLivingNbors[i][j] = getLivingNeighbors(i,j);
			}
		}
		for (int j = 0; j < cells.length; j++) {
			for (int i = 0; i < cells.length; i++) {
					cells[i][j].liveOrDie(numLivingNbors[i][j]);
			}
		}
		
		draw();
	}
	
	//returns an array list of the  8 or less neighbors of the 
	//cell identified by x and y
	public void draw() {
		reDraw();

	}
	public int getLivingNeighbors(int x, int y){
		int livingNeighbors = 0;
		if (x != 0) {
			if (cells[x - 1][y].isAlive == true) {
				livingNeighbors++;
			}
			if (y != cells[y].length - 1) {
			if (cells[x - 1][y + 1].isAlive == true) {
				livingNeighbors++;
			}
			}
			if (y != 0) {
			if (cells[x - 1][y - 1].isAlive == true ) {
				livingNeighbors++;
			}
			}
		}
		if (y != 0) {
			if (cells[x][y - 1].isAlive == true) {
				livingNeighbors++;
			}
			if (x != cells[x].length - 1) {
			if (cells[x + 1][y - 1].isAlive == true) {
				livingNeighbors++;
			}
			}
		}
		if (x != cells[x].length - 1) {
		if (cells[x + 1][y].isAlive == true) {
			livingNeighbors++;
		}
			if (y != cells[y].length - 1) {
				if (cells[x + 1][y + 1].isAlive == true) {
					livingNeighbors++;
				}
			}
		}
		if (y != cells[y].length - 1) {
		if (cells[x][y + 1].isAlive == true) {
			livingNeighbors++;
		}
		}
	
		
		
		
		//add 1 to livingNeighbors for each
		//neighboring cell that is alive
		
		return livingNeighbors;
	}
	public int getTimer() {
		return timer.getDelay();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// IGNORE
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// IGNORE
		
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// IGNORE
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}