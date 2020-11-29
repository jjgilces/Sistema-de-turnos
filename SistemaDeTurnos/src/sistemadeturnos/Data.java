/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeturnos;

import TDA.CircularSimplyLinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.Medico;
import modelo.Paciente;
import modelo.Sintoma;

/**
 *
 * @author user
 */
public class Data {
     public static List<Sintoma> sintomas = new ArrayList<>();
     public static CircularSimplyLinkedList<String> videos = new CircularSimplyLinkedList<>();
     public static LinkedList<Paciente> pacientes = new LinkedList<>();
     public static LinkedList<Medico> medicos = new LinkedList<>();
     public static List<String> especialidades = new ArrayList<>();
}
