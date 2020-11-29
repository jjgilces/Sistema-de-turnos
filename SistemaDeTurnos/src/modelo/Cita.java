
package modelo;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Cita implements Serializable{
    private Turno turno;
    private Puesto puesto;

    public Cita(Turno turno, Puesto puesto) {
        this.turno = turno;
        this.puesto = puesto;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return  turno + ", puesto=" + puesto + '}';
    }
    
    
}
