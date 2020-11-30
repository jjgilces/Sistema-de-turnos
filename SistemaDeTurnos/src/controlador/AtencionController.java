/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Atencion;
import modelo.Paciente;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AtencionController implements Initializable, Ventana {

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtApellidoPaciente;

    @FXML
    private TextField txtSintoma;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtGenero;

    @FXML
    private TextArea txtAreaReceta;

    @FXML
    private TextArea txtAreaDiagnostico;

    //GUARDAR ATENCION
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnGuardar;
    
    
    private Paciente paciente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void fillInData(Paciente patient) {
        this.txtEdad.setText(String.valueOf(patient.getEdad()));
        this.txtGenero.setText(patient.getGenero());
        this.paciente = patient;
        this.txtSintoma.setText(patient.getSintoma().getNombre());
        this.txtNombrePaciente.setText(patient.getNombres());
        this.txtApellidoPaciente.setText(patient.getApellidos());
    }

    @Override
    public void clickCancelar(ActionEvent e) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    
    public void clickGuardar(ActionEvent e){
        File f = new File("src/recursos/RegistroAtencion.txt");
        try( FileWriter fr = new FileWriter(f,true) ) {
            Atencion a = new Atencion(paciente,txtAreaReceta.getText().trim(),txtAreaDiagnostico.getText().trim());
            fr.write(a.toString());
        } catch (IOException ex) {
            Logger.getLogger(AtencionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        TablaController.removerCita();
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }
}
