package main;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import floor.River;
import floor.Road;
import floor.StopFloor;
import frog.Frog;

public class Froagger extends Applet implements Runnable {
	Thread animacion;
	Image imagen;
	Graphics noseve;
	Frog frog;
	StopFloor saveFloor, saveFloor2;
	Road road, road2, road3;
	River river, river2, river3, river4;
	// Reconociendo tama�o de pantalla(declaraciones)
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize;

	public void init() {
		// obteniendo tama�o de pantalla
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		resize(screenSize.width, screenSize.height);
		imagen = createImage(screenSize.width, screenSize.height);

		noseve = imagen.getGraphics();
		frog = new Frog(screenSize.height * 78 / 100, screenSize.width / 2, 50, 50);
		saveFloor = new StopFloor(screenSize.height * 78 / 100, 0, screenSize.width, frog.velY);
		road = new Road(screenSize.height * 78 / 100 - frog.velY, -10, screenSize.width + 10, frog.velY);
		road2 = new Road(road.y - frog.velY, -10, screenSize.width + 10, frog.velY);
		road3 = new Road(road2.y - frog.velY, -10, screenSize.width + 10, frog.velY);
		saveFloor2 = new StopFloor(road3.y - frog.velY, 0, screenSize.width, frog.velY);
		river = new River(saveFloor2.y - frog.velY, 0, screenSize.width, frog.velY);
		river2 = new River(river.y - frog.velY, 0, screenSize.width, frog.velY);
		river3 = new River(river2.y - frog.velY, 0, screenSize.width, frog.velY);
		river4 = new River(river3.y - frog.velY, 0, screenSize.width, frog.velY);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 1920, 1080);
		// suelo a salvo
		saveFloor.dibujar(noseve);
		// carretera
		road.dibujar(noseve);
		road2.dibujar(noseve);
		road3.dibujar(noseve);
		saveFloor2.dibujar(noseve);
		river.dibujar(noseve);
		river2.dibujar(noseve);
		river3.dibujar(noseve);
		river4.dibujar(noseve);
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
