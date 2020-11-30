/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serializado;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static sistemadeturnos.SistemaDeTurnos.medicos;
import static sistemadeturnos.SistemaDeTurnos.pacientes;
import static sistemadeturnos.SistemaDeTurnos.puestosAsignados;

/**
 *
 * @author JG
 */
public abstract class Serializable {
    
    public static void  guardarObjeto(String source, Object o){
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("src/recursos/archivos/"+source));){
            oos.writeObject(o);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo"+source+ex);
        } catch (IOException ex) {
            System.err.println(source);
        }
    }
    public static void serializarListas() {
        guardarObjeto("medicos", medicos);
        guardarObjeto("puestos",puestosAsignados);
        guardarObjeto("pacientes",pacientes);
    }
}
