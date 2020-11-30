
package modelo;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Medico extends Persona implements Serializable {

    private String especialidad;

    public Medico(String nombres, String apellidos, String especialidad) {
        super(nombres,apellidos);
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
        return especialidad+ ":\t" + nombres +" " + apellidos ;
    }


    
}
