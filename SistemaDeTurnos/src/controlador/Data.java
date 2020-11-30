/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import TDA.CircularSimplyLinkedList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sintoma;

/**
 *
 * @author user
 */
public class Data {
    /*Se encarga de intanciar los datos guardados acualmente*/

     public static  List<Sintoma> sintomas = new ArrayList<>();
     public static  List<String> especialidades = new LinkedList<>(); 
     public static  CircularSimplyLinkedList<String> videos = new CircularSimplyLinkedList<>();
     public static  PriorityQueue<Paciente> pacientes = new PriorityQueue<>((Paciente p1, Paciente p2)-> p1.getSintoma().getPrioridad()-p2.getSintoma().getPrioridad());
     public static  List<Medico> medicos = new LinkedList<>();
     public static  PriorityQueue<Cita> citas= new PriorityQueue<>((Cita p1, Cita p2)-> p1.getTurno().getPaciente().getSintoma().getPrioridad()-p2.getTurno().getPaciente().getSintoma().getPrioridad());
     public static  Queue<Puesto> puestosAsignados = new LinkedList<>();

}
