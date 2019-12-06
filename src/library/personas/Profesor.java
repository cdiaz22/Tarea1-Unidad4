package library.personas;

public class Profesor extends Persona {
    private int numeroEmpleado = 0;

    public Profesor(String nombre, String apellidoPaterno, int edad, int numeroEmpleado) {
        super(nombre, apellidoPaterno, edad);
        this.numeroEmpleado = numeroEmpleado;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "numeroEmpleado=" + numeroEmpleado +
                "} " + super.toString();
    }
}
