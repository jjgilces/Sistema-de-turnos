/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Alerta;
import static Serializado.Alerta.mostrarAlerta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Paciente;
import modelo.Sintoma;
import modelo.CrearCita;
import static sistemadeturnos.SistemaDeTurnos.pacientes;
import static sistemadeturnos.SistemaDeTurnos.puestosAsignados;
import static sistemadeturnos.SistemaDeTurnos.sintomas;


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
    private ComboBox cboSintoma;
    @FXML
    private Button btnRegistrar;

    public static final String text = "Datos Incorrectos";
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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
            boolean mostrar = CrearCita.asignarPuestoATurno(p1, puestosAsignados);      
            if(mostrar) {
                Alerta.Confirmar("Espere su turno, en breve lo atendemos", AlertType.CONFIRMATION);
                TablaController.updateTable();
            }
            else {
                pacientes.offer(p1);
                mostrarAlerta("En breve será atendido por un doctor.","Medicos Insuficientes", AlertType.INFORMATION);
            }
            
            txtNombre.clear();
            txtApellidos.clear();
            txtEdad.clear();         
        } catch (NumberFormatException ex) {
            txtEdad.clear();
            mostrarAlerta("Ingrese solo numeros porfavor",text, AlertType.ERROR);
        } catch (IllegalArgumentException ex) {
            if (!(isAlpha(txtNombre.getText()) && isAlpha(txtApellidos.getText()))) {
                mostrarAlerta("En los campos Nombre y Apellido utilice unicamente letras porfavor.",text, AlertType.ERROR);
            }
            if (Integer.parseInt(txtEdad.getText()) < 0) {
                txtEdad.clear();
                mostrarAlerta("Ingrese solo numeros positivos porfavor.",text, AlertType.ERROR);
            }

        }
        
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    @Override
    public  void clickCancelar(ActionEvent e){
        Stage stage = (Stage) btnRegistrar.getScene().getWindow();
        stage.close();
    }

}
