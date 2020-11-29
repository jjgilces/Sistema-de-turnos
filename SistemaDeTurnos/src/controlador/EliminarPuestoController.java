
package controlador;

import Serializado.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

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
    private ComboBox CBespecialidades;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CBespecialidades.getItems().addAll(Data.medicos);
        
    }    

    @Override
    public  void clickCancelar(ActionEvent e){
        Platform.exit();
    }
//        @FXML
//    void eliminarPuesto(){
//        Optional<ButtonType> result = Alerts.confirmPuestoDelete();
//        if(result.get()==ButtonType.OK){
//            Puesto puesto = cmbPuesto.getValue();
//            Medico med = puesto.getMedico();
//            med.setPuesto(null);
//            LPuesto.remove(puesto);
//            LMedico.add(med);
//            loadData();
//            
//        }  
//    }
}
