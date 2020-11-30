
package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class BotonesController {
    //Clase que se encarga de crear los metodos de cada boton
    @FXML
    private final Button btnRPaciente;

    @FXML
    private final Button btnRDoctor;

    @FXML
    private final Button btnCrearPuesto;

    @FXML
    private final Button btnEliminarPuesto;
        
    private static final String name = "Formulario Paciente";
    
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
            stage.setTitle(name);
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
            stage.setTitle(name);
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
            stage.setTitle(name);
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
            stage.setTitle(name);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
