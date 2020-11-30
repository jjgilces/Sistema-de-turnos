/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author HatusP
 */
public class BaseDatos {

    //Los objetos Paciente son serializados en esta lista de Pacientes y guardados en un archivo
    //Este modelo se puede extender a para guardar los datos de cualquier objeto dentro del programa
    public static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public static ArrayList<Medico> listaMedicos = new ArrayList<>();


}
