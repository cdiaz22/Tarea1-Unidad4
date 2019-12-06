package library.personas;

public class Estudiante extends Persona {
    private int matricula = 0;

    public Estudiante(String nombre, String apellidoPaterno, int edad, int matricula) {
        super(nombre, apellidoPaterno, edad);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getRaizCuadrada(int i) {
        return (int) Math.sqrt(i);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                "} " + super.toString();
    }
}
