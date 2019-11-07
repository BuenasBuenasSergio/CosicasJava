package frog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Frog extends Rectangle {

	Color color;
	public boolean arriba = false;
	public boolean derecha = false;
	public boolean izquierda = false;
	public boolean abajo = false;
	int velX = 5;
	int velY = 5;

	public Frog(int posY, int posX, int height, int width) {
		super(posX, posY, height, width);
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}

	public void actualizar() {
		if (arriba) {
			upMove();
		}
		if (abajo) {

			downMove();
		}
		if (derecha) {

			rightMove();
		}
		if (izquierda) {

			leftMove();
		}

	}

	public void upMove() {
		y += velY;
	}

	public void downMove() {
		y -= velY;
	}

	public void leftMove() {
		x -= velX;
	}

	public void rightMove() {

		x += velX;
	}

}
