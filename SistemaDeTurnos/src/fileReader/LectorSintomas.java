/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sintoma;
import static Serializado.Data.sintomas;


/**
 *
 * @author user
 */
public class LectorSintomas{

    public static void leerArchivo() {
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
}
