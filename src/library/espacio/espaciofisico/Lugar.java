package library.espacio.espaciofisico;

import java.util.Vector;

public class Lugar extends EspacioFisico {
	private String nombre = "";
	private Evento elEvento;
	private Vector<Objeto> losObjetos = new Vector<Objeto>();

	public Lugar(String nombre) {
		this.nombre = nombre;
	}

	public Vector<Objeto> getLosObjetos() {
		return losObjetos;
	}

	public void setLosObjetos(Vector<Objeto> losObjetos) {
		this.losObjetos = losObjetos;
	}

	@Override
	public String toString() {
		return "Lugar{" +
				"nombre='" + nombre + '\'' +
				", losObjetos=" + losObjetos +
				"} ";
	}
}