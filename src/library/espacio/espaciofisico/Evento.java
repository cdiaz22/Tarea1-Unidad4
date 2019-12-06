package library.espacio.espaciofisico;

import java.io.Serializable;

public class Evento implements Serializable {
	private Lugar elLugar;
	private Posicion laPosicion;

	public Evento(Lugar elLugar, Posicion laPosicion) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}

	public void setElLugar(Lugar elLugar) {
		this.elLugar = elLugar;
	}

	public Lugar getElLugar() {
		return this.elLugar;
	}

	public void setLaPosicion(Posicion laPosicion) {
		this.laPosicion = laPosicion;
	}

	public Posicion getLaPosicion() {
		return this.laPosicion;
	}
}