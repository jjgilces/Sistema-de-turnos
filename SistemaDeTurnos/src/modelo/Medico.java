
package modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author user
 */
public class Medico implements Serializable{
    private String nombres;
    private String apellidos;
    private String especialidad;

    public Medico(String nombres, String apellidos, String especialidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        return "Medico{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", especialidad=" + especialidad + '}';
    }


    
}
