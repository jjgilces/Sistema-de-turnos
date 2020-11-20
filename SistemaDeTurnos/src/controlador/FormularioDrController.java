/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelo.Medico;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author User
 */
public class FormularioDrController implements Initializable {

    @FXML
    public TextField txtNombre;
    
    
    @FXML
    public TextField txtApellido;
    
    public LinkedList<Medico> med = new LinkedList<>();
    @Override
   
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    }
