
package controlador;

import Serializado.Alerta;
import static controlador.Data.citas;
import static controlador.Data.puestosAsignados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.Medico;
import modelo.Puesto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class EliminarPuestoController implements Initializable,Ventana {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button cancelarBtn;
    
    @FXML
    private ComboBox CBpuestoasig;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBpuestoasig.getItems().addAll(Data.puestosAsignados);
    }    

    @Override
    public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) cancelarBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    void deletePuesto(ActionEvent event) {
        
        if (validate(CBpuestoasig)) {
            Alerta.mostrarAlerta("No hay ninguna seleccion","Verifique su seleccion", Alert.AlertType.ERROR);
        }
        else  {
            Puesto p = (Puesto) CBpuestoasig.getValue();
            if (delete(p.getMedico())) {
                Data.medicos.add(p.getMedico());
                puestosAsignados.remove(p);
                CBpuestoasig.getItems().remove(p);
                    Alerta.confirmPuestoDelete();    
            }
            else 
                Alerta.mostrarAlerta("Este doctor se encuentra asignado a una cita", "Espere un momento", Alert.AlertType.ERROR);
        }
           System.out.println(Data.citas);
    }
    
    public boolean validate(ComboBox c) {
        return c.getValue() == null;
    }
    
    
    public boolean delete(Medico med) {
        for (Cita c: citas)
            if (c.getPuesto().getMedico().equals(med)) {
                return false;
            }
        return true;
    }
    
    
}
