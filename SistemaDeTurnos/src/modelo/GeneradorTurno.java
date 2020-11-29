
package modelo;

import java.util.Random;

/**
 *
 * @author Johan
 */
public class GeneradorTurno {
    public static Random  numAleatorio = new Random();
    public static Turno generarTurnoConPaciente(Paciente p){
        int n = numAleatorio.nextInt(300-100+1) + 100;
        Sintoma s = p.getSintoma();
        String letra = "";
        switch(s.getPrioridad()){
            case 0:
                letra = "A";
                break;
            case 1:
                letra = "B";
                break;
            case 2:
                letra = "C";
                break;
            case 3:
                letra = "D";
                break;
            case 4:
                letra = "E";
                break;
            case 5:
                letra = "F";
                break;
        }
        String nTurno = letra + n;
        return new Turno(nTurno,p);
                
    }

}
