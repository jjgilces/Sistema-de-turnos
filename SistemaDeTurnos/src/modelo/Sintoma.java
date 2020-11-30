/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;


/**
 *
 * @author User
 */
public class Sintoma implements Serializable{
    private String nombre;
    private int prioridad;
    private final long serialVersionUID = 12312312;
   
    public Sintoma(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return nombre  ;
    }
    
}
