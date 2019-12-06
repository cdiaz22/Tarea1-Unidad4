package library.personas;

public class Persona {
    private String nombre = "sin nombre";
    private String apellidoPaterno = "Sin apellido";
    private int edad = 0;

    public Persona(String nombre, String apellidoPaterno, int edad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", edad=" + edad +
                '}';
    }
}
