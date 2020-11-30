/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        System.out.println(sintomas);
        Sintoma s = sintomas.get(0);
        System.out.println(s);
        Paciente p = new Paciente("Juan", "Gilces", 10, "masculino", s);
        Medico medico = new Medico("Jose", "PEPE", "Cardiolgo");
        Puesto puesto = new Puesto(2, medico);
        Turno turno = new Turno("A209", p);
        Cita c = new Cita(turno, puesto);
        citas.add(c);
        tableList.add(c);
        tableList.add(c);
//        tbTurnoCita.getItems().add(c);
    }
 
     @FXML
    private void antenderPaciente(MouseEvent event) {
        try {
            Turno turnoSelect = tbTurnoCita.getSelectionModel().getSelectedItem().getTurno();
            Puesto puestoSelect = tbTurnoCita.getSelectionModel().getSelectedItem().getPuesto();      
            Stage anotherStage = new Stage();
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/vista/Atencion.fxml"));
            Parent root1 = loader1.load();
            pantallaAternderPaciente = loader1.getController();
//            pantallaAternderPaciente.fillInData(turnoSelect.getPaciente());
            Scene scene1 = new Scene(root1);
//            pantallaAternderPaciente.setPrincipal(this);
            anotherStage.setScene(scene1);
            anotherStage.show();
        }catch(NullPointerException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Alert");
            alert.setHeaderText("No ha seleccionado un turno o la tabla está vacía");
            alert.setContentText("Añada pacientes para llenar la tabla o de clic en un turno existente.");
            alert.show();
        } 
        catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static void updateTable(Cita c) {
        tableList.add(c);
    }
    
}
