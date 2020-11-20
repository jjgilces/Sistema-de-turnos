
package modelo;

/**
 *
 * @author user
 */
public class Paciente {
    private String nombres;
    private String apellidos;
    private int edad;
    private String genero;
    private int prioridad;

    public Paciente(String nombres, String apellidos, int edad, String genero, int prioridad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", genero=" + genero + ", prioridad=" + prioridad + '}';
    }
    
    
}




















