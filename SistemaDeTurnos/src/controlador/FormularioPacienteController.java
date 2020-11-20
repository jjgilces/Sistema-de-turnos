/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import modelo.Sintoma;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FormularioPacienteController implements Initializable {
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtEdad;
    @FXML
    private RadioButton rbtMasculino;
    @FXML
    private RadioButton rbtFemenino;
    @FXML
    private ComboBox cboSintoma;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnRegistrar;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cboSintoma.getItems().addAll(Sintoma.sintomas);
    }    
    
}
