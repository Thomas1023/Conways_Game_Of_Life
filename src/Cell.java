import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cell implements Drawable{
	public boolean isAlive = false;
	private int x;
	private int y;
	private int cellSize;
	public Cell(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.cellSize = size;
	}
	public void liveOrDie(int numNeighbors) {
		if (numNeighbors < 2) {
			isAlive = false;
		}if (numNeighbors > 3) {
			isAlive = false;
		}if (numNeighbors == 3) {
			isAlive = true;
		}
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public void draw(Graphics g) {
		if (isAlive == true) {
			if(ConwaysGameOfLife.CRT) {
				Random rand = new Random();
				Random rand1 = new Random();
				Random rand2 = new Random();

				g.setColor(new Color(rand.nextInt(255),rand1.nextInt(255),rand2.nextInt(255)));
				
			}else {
			g.setColor(Color.green);
			}
			g.fillRect(x, y, cellSize, cellSize);
		} else {
			g.setColor(new Color(238,238,238));
			g.fillRect(x, y, cellSize, cellSize);
		}
	}
}