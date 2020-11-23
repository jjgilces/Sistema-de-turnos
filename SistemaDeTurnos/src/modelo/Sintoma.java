/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Sintoma {
    private String nombre;
    private int prioridad;
    public static List<Sintoma> sintomas = new ArrayList<>();

    public Sintoma(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    public static void llenarSintomas(){
        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/recursos/sintomas.txt"));
            for(String l : lineas){
                String[] separado = l.split("\\|");
                
                sintomas.add(new Sintoma(separado[0],Integer.parseInt(separado[1].trim())));
            }
        } catch (IOException ex) {
            System.out.println(ex.getCause());
            Logger.getLogger(Sintoma.class.getName()).log(Level.SEVERE, null, ex);
            
        }
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
        return nombre +"| " + prioridad;
    }
    
}