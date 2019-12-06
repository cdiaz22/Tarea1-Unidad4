package library.espacio.espaciofisico;

import java.io.Serializable;

public class Posicion implements Serializable {
	private int x = 0;
	private int y = 0;

	private Objeto elObjeto;
	private Evento elEvento;

	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public void setElObjeto(Objeto elObjeto) {
		this.elObjeto = elObjeto;
	}

	public Objeto getElObjeto() {
		return this.elObjeto;
	}

	public void setElEvento(Evento elEvento) {
		this.elEvento = elEvento;
	}

	public Evento getElEvento() {
		return this.elEvento;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Posicion{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}