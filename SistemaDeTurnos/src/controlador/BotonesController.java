
package controlador;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class BotonesController {
    //Clase que se encarga de crear los metodos de cada boton
    @FXML
    private Button btnRPaciente;

    @FXML
    private Button btnRDoctor;

    @FXML
    private Button btnCrearPuesto;

    @FXML
    private Button btnEliminarPuesto;

    public BotonesController(Button btnRPaciente, Button btnRDoctor, Button btnCrearPuesto, Button btnEliminarPuesto) {
       
        this.btnRPaciente = btnRPaciente;
        this.btnRDoctor = btnRDoctor;
        this.btnCrearPuesto = btnCrearPuesto;
        this.btnEliminarPuesto = btnEliminarPuesto;
    }
    
    public void setearbotones(){
        btnRPaciente.setOnMouseClicked(e -> {cambioVentanaPaciente();});
        btnRDoctor.setOnMouseClicked(e -> {cambioVentanaDoctor();});
        btnCrearPuesto.setOnMouseClicked(e->{ cambioVentanaAddPuesto();});
        btnEliminarPuesto.setOnMouseClicked(e->{ cambioVentanaDeletePuesto(); });
    
    }
    public  void cambioVentanaPaciente() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioPaciente.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Formulario Paciente");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void cambioVentanaDoctor() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioDr.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Formulario Paciente");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void cambioVentanaAddPuesto() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/Puesto.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Formulario Paciente");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public  void cambioVentanaDeletePuesto() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/EliminarPuesto.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Formulario Paciente");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static void eliminarPuesto(){
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
//     public static void guardarPuesto(ActionEvent event) {
//        Puesto puesto = new Puesto(txtNumeroPuesto.getText(), cmbMedicoresponsable.getValue());
//        cmbMedicoresponsable.getValue().setPuesto(puesto);
//        principal.getPuestosLibres().add(puesto);
//        principal.asignarPuestoATurno();
//        LPuesto.add(puesto);
//        loadData();
//        txtNumeroPuesto.setText("");
//        cmbMedicoresponsable.setValue(null);
//    }
}
