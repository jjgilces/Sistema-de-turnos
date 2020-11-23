/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
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
            Paciente p1 = new Paciente(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()), genero, sintoma.getPrioridad());

        } catch (NumberFormatException ex) {
            txtEdad.clear();
            mostrarAlerta("Ingrese solo numeros porfavor", AlertType.ERROR);
        } catch (IllegalArgumentException ex) {

            if (!(isAlpha(txtNombre.getText()) && isAlpha(txtApellidos.getText()))) {
                txtNombre.clear();
                txtApellidos.clear();
                mostrarAlerta("En los campos Nombre y Apellido utilice unicamente letras porfavor.", AlertType.ERROR);
            }
            if (Integer.parseInt(txtEdad.getText()) < 0) {
                txtEdad.clear();
                mostrarAlerta("Ingrese solo numeros positivos porfavor.", AlertType.ERROR);
            }

        }
    }

    public static void mostrarAlerta(String mensaje, AlertType e) {
        Alert alert = new Alert(e);
        
        alert.setTitle("Error!");
        alert.setHeaderText("Hubo un error en el ingreso de datos!");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public void clickSalir(ActionEvent e) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

}
