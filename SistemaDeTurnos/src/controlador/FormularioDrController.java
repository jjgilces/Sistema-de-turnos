/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Alerta;
import static Serializado.Data.medicos;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import modelo.Medico;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FormularioDrController implements Initializable {

    @FXML
    public TextField txtNombre;

    @FXML
    private ComboBox<String> especialidad;

    @FXML
    private Label labelEspe;

    @FXML
    public TextField txtApellido;

    @FXML
    private Button closebtn;

    @FXML
    private Label labelName;

    @FXML
    private Label labelLast;

    private ObservableList<String> items;

    public LinkedList<Medico> med = new LinkedList<>();

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    @FXML

    void saveData(ActionEvent event) {
        boolean condition1 = textFieldNull(txtNombre, labelName, "El campo esta vacio");
        boolean condition2 = textFieldNull(txtApellido, labelLast, "El campo esta vacio");
        boolean condition3 = combobox(especialidad, labelEspe, "Se requiere seleccion");
        if (condition1 || condition2 || condition3) {
            Alerta.mostrarAlerta("Los campos estan vacios", AlertType.INFORMATION);
        } else {
            Medico med = new Medico(txtNombre.getText(), txtApellido.getText(), especialidad.getValue());
            medicos.add(med);
            Alerta.Confirmar("Se ha registrado el médico", AlertType.CONFIRMATION);      
        }
        txtNombre.setText("");
        txtApellido.setText("");
        loadData();
    }

    public static boolean textFieldNull(TextField text, Label label, String validate) {
        boolean isNull = false;
        String val = null;
        if (text.getText().isEmpty()) {
            isNull = true;
            val = validate;
        } else if (!text.getText().matches("[a-zA-Z]+")) {
            System.out.println("else if");
            isNull = true;
            val = "Se requiere letras";
        }
        label.setText(val);
        return isNull;
    }

    public boolean combobox(ComboBox cb, Label l, String validate) {
        boolean isNull = false;
        String val = null;
        if (cb.getValue() == null || cb.getValue().toString().isEmpty()) {
            isNull = true;
            val = validate;
        }
        l.setText(val);
        return isNull;
    }

    private void loadData() {
        items = FXCollections.observableArrayList();
        items.addAll("Medicina General", "Alergología", "Cardiología", "Angiología", "Cirugía General", "Dermatología", "Endocrinología", "Ecografía", "Hematología");
        items.sort(null);
        especialidad.getItems().setAll(items);
    }

    @FXML
    void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) closebtn.getScene().getWindow();
        stage.close();
    }
}
