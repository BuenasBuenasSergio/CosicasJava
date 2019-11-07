package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import frog.Frog;

public class Froagger extends Applet implements Runnable {
	Thread animacion;
	Image imagen;
	Graphics noseve;
	Frog frog;
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize;

	public void init() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		resize(screenSize.width, screenSize.height);
		imagen = createImage(1920, 1080);
		noseve = imagen.getGraphics();
		frog = new Frog(100, 100, 200, 200);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 1920, 1080);
		frog.dibujar(noseve);
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {

			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
		}

	}

	public boolean keyDown(Event ev, int tecla) {
		switch (tecla) {
		// derecha
		case 100:
			frog.izquierda = false;
			frog.arriba = false;
			frog.abajo = false;
			frog.derecha = true;
			frog.actualizar();

			break;
		// izquierda
		case 97:
			frog.arriba = false;
			frog.abajo = false;
			frog.derecha = false;
			frog.izquierda = true;
			frog.actualizar();

			break;
		// arriba
		case 115:

			frog.arriba = true;
			frog.abajo = false;
			frog.derecha = false;
			frog.izquierda = false;
			frog.actualizar();

			break;
		// abajo
		case 119:
			frog.arriba = false;
			frog.abajo = true;
			frog.derecha = false;
			frog.izquierda = false;
			frog.actualizar();

			break;
		}
		repaint();
		return true;
	}
}
