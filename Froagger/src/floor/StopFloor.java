package floor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class StopFloor extends Rectangle {

	Color color;
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize;

	public StopFloor(int posY, int posX, int height, int width) {
		super(posX, posY, height, width);
		screenSize = t.getScreenSize();
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.yellow);
		g.fillRect(x, y, width, height);
	}

}
