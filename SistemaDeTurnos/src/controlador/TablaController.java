/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Alerta;
import Serializado.Data;
import static Serializado.Data.citas;
import static Serializado.Data.sintomas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.GeneradorTurno;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sintoma;
import modelo.Turno;

/**
 *
 * @author user
 */
public class TablaController {
    @FXML
    private TableColumn<Turno,Cita> colTurno;
    @FXML
    private TableColumn<Puesto,Cita> colPuesto;
    @FXML
    private  TableView<Cita> tbTurnoCita;
    
    private SistemaPController principal;
    
    public static  ObservableList<Cita> tableList;
    private AtencionController pantallaAternderPaciente;
    public TablaController(TableColumn<Turno, Cita> colTurno, TableColumn<Puesto, Cita> colPuesto, TableView<Cita> tbTurnoCita) {
        this.colTurno = colTurno;
        this.colPuesto = colPuesto;
        this.tbTurnoCita = tbTurnoCita;
        this.tbTurnoCita.setOnMouseClicked(e -> antenderPaciente(e));
    }


    public void mostrarTabla(){
        colTurno.setCellValueFactory(new PropertyValueFactory("Turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("Puesto"));
        tbTurnoCita.setEditable(true);
        tableList = FXCollections.observableArrayList();
        tbTurnoCita.setItems(tableList);
        tbTurnoCita.setPlaceholder(new Text("No hay citas")); 
    }
 
     @FXML
    private void antenderPaciente(MouseEvent event) {
        try {
            Cita citaSeleccionada = tbTurnoCita.getSelectionModel().getSelectedItem();
            Cita cita = tbTurnoCita.getItems().get(0); 
            System.out.println(cita);
            System.out.println(citaSeleccionada);
            if(citaSeleccionada.equals(cita)){
            Stage anotherStage = new Stage();
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/vista/Atencion.fxml"));
            Parent root1 = loader1.load();
            pantallaAternderPaciente = loader1.getController();
            pantallaAternderPaciente.fillInData(citaSeleccionada.getTurno().getPaciente());
            Scene scene1 = new Scene(root1);
            anotherStage.setScene(scene1);
            anotherStage.show();
            }
        }catch(NullPointerException ex){
            System.out.println(ex);
            Alerta.mostrarAlerta("No ha seleccionado una cita ", "Error", Alert.AlertType.ERROR);
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
        
    }
    public static void updateTable() {
        tableList.clear();
        tableList.addAll(citas);
    }
}
