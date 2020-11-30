
package modelo;

import static controlador.Data.citas;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Johan
 */
public class CrearCita {
    public static List<Cita> l = new LinkedList<>();
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
            return true;
        }
        return false;
    }
}
