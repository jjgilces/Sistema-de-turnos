
package modelo;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Paciente implements Serializable {
    private String nombres;
    private String apellidos;
    private int edad;
    private String genero;
    private int prioridad;
    private static final long serialVersionUID = 12312312;

    public Paciente(String nombres, String apellidos, int edad, String genero, int prioridad)  {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return  nombres + apellidos + prioridad ;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    
    
}




















