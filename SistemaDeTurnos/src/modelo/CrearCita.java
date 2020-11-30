
package modelo;

import static Serializado.Data.citas;
import java.util.LinkedList;
import java.util.Queue;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Johan
 */
public class CrearCita {
    public static LinkedList<Cita> l = new LinkedList<>();
    public static boolean asignarPuestoATurno(Paciente p, Queue<Puesto> puestosAsignados ) {
        if(!puestosAsignados.isEmpty()){
            Turno turno =  GeneradorTurno.generarTurnoConPaciente(p);
            Puesto puesto = puestosAsignados.poll();
            Cita cita = new Cita(turno, puesto);
            LinkedList<Cita > l = new LinkedList<>();
            citas.add(cita);
            l.addAll(citas);
            citas.clear();
            citas.addAll(l);
            System.out.println(l);
            System.out.println(citas);
            return true;
        }
        return false;
    }
}
