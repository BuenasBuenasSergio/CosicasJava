package floor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class River extends Rectangle {
	Color color;
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize;

	public River(int posY, int posX, int height, int width) {
		super(posX, posY, height, width);
		screenSize = t.getScreenSize();
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);
	}
}
