package library.espacio.espaciofisico;

import java.io.Serializable;

/**
 * Class description
 */
public class Objeto implements Serializable {
	private String nombre;
	private Posicion laPosicion;
	private Lugar elLugar;

	public Objeto(String nombre, Posicion laPosicion, Lugar elLugar) {
		this.nombre = nombre;
		this.laPosicion = laPosicion;
		this.elLugar = elLugar;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setLaPosicion(Posicion laPosicion) {
		this.laPosicion = laPosicion;
	}

	public Posicion getLaPosicion() {
		return this.laPosicion;
	}

	public void setElLugar(Lugar elLugar) {
		this.elLugar = elLugar;
	}

	public Lugar getElLugar() {
		return this.elLugar;
	}

	@Override
	public String toString() {
		return "Objeto{" +
				"nombre='" + nombre + '\'' +
				", laPosicion=" + laPosicion +
				'}';
	}
}