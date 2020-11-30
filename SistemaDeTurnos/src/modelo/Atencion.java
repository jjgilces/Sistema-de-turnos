    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**zx
 * @author User
 */
public class Atencion {
    Paciente paciente;
    String diagnostico;
    String receta;

    public Atencion(Paciente paciente, String diagnostico, String receta) {
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "Atencion{" + "paciente=" + paciente + ", diagnostico=" + diagnostico + ", receta=" + receta + '}';
    }
    
}
