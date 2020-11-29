/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Data;
import java.net.URL;
import java.util.Queue;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnCrearPuesto.
    }  
    @FXML
    void CreacionPuesto(ActionEvent e){
        Queue<Medico> medicos= Data.medicosAsignados;
        if(medicos.isEmpty()) SistemaPController.mostrarAlerta("No tenemo medicos disponibles",Alert.AlertType.INFORMATION);
        else{Puesto puesto = new Puesto(1, medicos.poll());}
    }
    
    @Override
     public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnCrearPuesto.getScene().getWindow();
        stage.close();
    }  
}
