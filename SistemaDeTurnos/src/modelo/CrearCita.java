
package modelo;

import static Serializado.Data.citas;
import java.util.Queue;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Johan
 */
public class CrearCita {
    public static boolean asignarPuestoATurno(Paciente p, Queue<Puesto> puestosAsignados ) {
        if(!puestosAsignados.isEmpty()){
            Turno turno =  GeneradorTurno.generarTurnoConPaciente(p);
            Puesto puesto = puestosAsignados.poll();
            Cita cita = new Cita(turno, puesto);
            citas.add(cita);
            return true;
        }
        return false;
    }
}
