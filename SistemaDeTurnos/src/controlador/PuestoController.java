
package controlador;

import Serializado.Alerta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.CrearCita;
import modelo.Medico;
import modelo.Puesto;
import static sistemadeturnos.SistemaDeTurnos.medicos;
import static sistemadeturnos.SistemaDeTurnos.pacientes;
import static sistemadeturnos.SistemaDeTurnos.puestosAsignados;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PuestoController implements Initializable,Ventana {
    
    private int turno =1 ;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
    
    
    
    @FXML
    private Button btnCrearPuesto;
    @FXML
    private ComboBox cbMedico;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMedico.getItems().addAll(medicos);
    }  

    
    @Override
     public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnCrearPuesto.getScene().getWindow();
        stage.close();
    }  
    @FXML
    void guardarPuesto(ActionEvent event) {
        if (validate(cbMedico)) {
            Alerta.mostrarAlerta("No hay ninguna seleccion","Verifique su seleccion", Alert.AlertType.ERROR);
        }
        else{
        Medico med = (Medico) cbMedico.getValue();
        Puesto puesto = new Puesto(turno, med);
        setTurno(getTurno()+1);
        medicos.remove(med);
        cbMedico.getItems().remove(med);
        puestosAsignados.add(puesto);
        Alerta.Confirmar("Puesto asignado", Alert.AlertType.CONFIRMATION);
        }
        if(!pacientes.isEmpty()) {CrearCita.asignarPuestoATurno(pacientes.poll(), puestosAsignados);
            TablaController.updateTable();
        }
    }
    
    public boolean validate(ComboBox c) {
        return c.getValue() == null;
    }
}
