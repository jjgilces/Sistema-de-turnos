/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import controlador.Data;
import modelo.Medico;

/**
 *
 * @author user
 */
public class CargarDatos {
    public static void cargarArchivos(){
        LectorEspecialidad.leerArchivo();
        LectorSintomas.leerArchivo();
        LectorVideos.leerArchivoVideos();
        Medico m1= new Medico("Johan", "Gilces Reyes", "Cardiólogo");
        Medico m2 = new Medico("Hatus", "Parra", "Medicina General");
        Data.medicos.add(m2);
        Data.medicos.add(m1);     
                
    }
}
