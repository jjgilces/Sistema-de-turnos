/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Alerta;
import static Serializado.Alerta.mostrarAlerta;
import Serializado.BaseDatos;
import Serializado.Data;
import static Serializado.Data.puestosAsignados;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Paciente;
import modelo.Sintoma;
import static Serializado.Data.sintomas;
import modelo.CrearCita;
import sistemadeturnos.SistemaDeTurnos;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FormularioPacienteController implements Initializable,Ventana {

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

    private TablaController tabla;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboSintoma.getItems().addAll(sintomas);
    }

    public void clickRegistrar(ActionEvent e) {
        try {
            String genero = rbtMasculino.isSelected() ? "Masculino" : "Femenino";
            Sintoma sintoma = (Sintoma) cboSintoma.getValue();
            if (Integer.parseInt(txtEdad.getText()) < 0) {
                throw new IllegalArgumentException();
            }
            if (!(isAlpha(txtNombre.getText()) && isAlpha(txtApellidos.getText()))) {
                throw new IllegalArgumentException();
            }
            Paciente p1 = new Paciente(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()), genero,sintoma);
            SistemaDeTurnos.listaPacientes.add(p1);
            BaseDatos.listaPacientes.add(p1);
            BaseDatos.guardarPacientes();
            //Hacer Excepcion de los turnos!
            boolean mostrar = CrearCita.asignarPuestoATurno(p1, puestosAsignados);      
            if(mostrar) {
                Alerta.Confirmar("Espere su turno, en breve lo atendemos", AlertType.CONFIRMATION);
//                SistemaPController.actualizarTabla();
            }
            else {
                Data.pacientes.offer(p1);
                Alerta.Confirmar("No tenemos medicos disponibles", AlertType.INFORMATION);
            }
            
            txtNombre.clear();
            txtApellidos.clear();
            txtEdad.clear();         
        } catch (NumberFormatException ex) {
            txtEdad.clear();
            mostrarAlerta("Ingrese solo numeros porfavor", AlertType.ERROR);
        } catch (IllegalArgumentException ex) {
            if (!(isAlpha(txtNombre.getText()) && isAlpha(txtApellidos.getText()))) {
                mostrarAlerta("En los campos Nombre y Apellido utilice unicamente letras porfavor.", AlertType.ERROR);
            }
            if (Integer.parseInt(txtEdad.getText()) < 0) {
                txtEdad.clear();
                mostrarAlerta("Ingrese solo numeros positivos porfavor.", AlertType.ERROR);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormularioPacienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // Alerta.Confirmar("Paciente creado con éxito", AlertType.CONFIRMATION);
        
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    @Override
    public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnRegistrar.getScene().getWindow();
        stage.close();
    }

}
