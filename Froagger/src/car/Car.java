package car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Car extends Rectangle {

	Color color;
	public boolean arriba = false;
	public boolean derecha = false;
	public boolean izquierda = false;
	public boolean abajo = false;
	int velX = 20;
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize;

	public Car(int posY, int posX, int height, int width) {
		super(posX, posY, height, width);
		screenSize = t.getScreenSize();
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

	public void actualizar() {
		leftMove();

	}

	public void leftMove() {
		x -= velX;
	}
}