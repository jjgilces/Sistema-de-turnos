/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Serializado.Alerta;
import static controlador.Data.citas;
import java.io.IOException;
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
import modelo.Puesto;
import modelo.Turno;

/**
 *
 * @author user
 */
public class TablaController {
    @FXML
    private final TableColumn<Turno,Cita> colTurno;
    @FXML
    private final TableColumn<Puesto,Cita> colPuesto;
    @FXML
    private final  TableView<Cita> tbTurnoCita;
    
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
            if(citaSeleccionada.equals(cita)){
            Stage anotherStage = new Stage();
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/vista/Atencion.fxml"));
            Parent root1 = loader1.load();
            pantallaAternderPaciente = loader1.getController();
            pantallaAternderPaciente.fillInData(citaSeleccionada.getTurno().getPaciente());
            Scene scene1 = new Scene(root1);
            anotherStage.setScene(scene1);
            anotherStage.show();
            }else{
                Alerta.mostrarAlerta("Por favor, atender al primer paciente", "Error de prioridad", Alert.AlertType.INFORMATION);
            }
        }catch(NullPointerException ex){
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
    
    public static void removerCita(){
        tableList.remove(0);
    }
}
