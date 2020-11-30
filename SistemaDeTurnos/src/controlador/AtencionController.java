/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private Button btnGuardar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void fillInData(Paciente patient) {
        this.txtEdad.setText(String.valueOf(patient.getEdad()));
        this.txtGenero.setText(patient.getGenero());
        this.txtSintoma.setText(patient.getSintoma().getNombre());
        this.txtNombrePaciente.setText(patient.getNombres());
        this.txtApellidoPaciente.setText(patient.getApellidos());
    }

    @Override
    public void clickCancelar(ActionEvent e) {
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }
    
}
