
package controlador;

import Serializado.Alerta;
import Serializado.Data;
import static Serializado.Data.medicos;
import static Serializado.Data.puestosAsignados;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import modelo.Medico;
import modelo.Puesto;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PuestoController implements Initializable,Ventana {

    @FXML
    private Button btnCrearPuesto;
    @FXML
    private ComboBox cbMedico;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbMedico.getItems().addAll(medicos);
    }  
//    @FXML
//    void CreacionPuesto(ActionEvent e){
//        Queue<Medico> medicos= Data.medicosAsignados;
//        if(medicos.isEmpty()) SistemaPController.mostrarAlerta("No tenemo medicos disponibles",Alert.AlertType.INFORMATION);
//        else{Puesto puesto = new Puesto(1, medicos.poll());}
//    }
    
    @Override
     public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnCrearPuesto.getScene().getWindow();
        stage.close();
    }  
    @FXML
    void guardarPuesto(ActionEvent event) {
        Puesto puesto = new Puesto(1, (Medico) cbMedico.getValue());
        medicos.remove(cbMedico.getValue());
        cbMedico.getItems().remove(cbMedico.getValue());
        puestosAsignados.add(puesto);
        System.out.println(medicos);
        Alerta.Confirmar("Puesto asignado", Alert.AlertType.CONFIRMATION);
    }

}
