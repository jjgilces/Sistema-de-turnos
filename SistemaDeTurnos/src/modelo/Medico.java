
package modelo;

/**
 *
 * @author user
 */
public class Medico {
    private String nombres;
    private String apellidos;

    public Medico(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Medico{" + "nombres=" + nombres + ", apellidos=" + apellidos + '}';
    }
    
    
    
}
