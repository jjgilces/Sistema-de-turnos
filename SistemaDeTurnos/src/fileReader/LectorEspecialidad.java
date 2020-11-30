/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sintoma;
import static Serializado.Data.especialidades;

/**
 *
 * @author User
 */
public class LectorEspecialidad {

    public static void leerArchivo() {
        try {
            List<String> lineas = Files.readAllLines(Paths.get("src/recursos/especialidades.txt"));
            for(String especialidad : lineas){
                especialidades.add(especialidad.trim());
            }
        } catch (IOException ex) {
            Logger.getLogger(Sintoma.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    
    
}
