package library.espacio.fisico;

public class Objeto {
	private String nombre = "";
	private Posicion laPosicion;

	public Objeto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Posicion getLaPosicion() {
		return laPosicion;
	}

	public void setLaPosicion(Posicion laPosicion) {
		this.laPosicion = laPosicion;
	}

	@Override
	public String toString() {
		return "Objeto{" +
				"nombre='" + nombre + '\'' +
				", laPosicion=" + laPosicion +
				'}';
	}
}
