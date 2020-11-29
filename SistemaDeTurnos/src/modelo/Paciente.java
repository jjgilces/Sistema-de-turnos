
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
    private Sintoma sintoma;
    private static final long serialVersionUID = 12312312;

    public Paciente(String nombres, String apellidos, int edad, String genero,Sintoma sintoma)  {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
        this.sintoma=sintoma;
    }

    @Override
    public String toString() {
        return  nombres + apellidos  ;
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


    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }
    
    
    
}




















