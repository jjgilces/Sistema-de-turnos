package controlador;


import static Serializado.Data.citas;
import static Serializado.Data.sintomas;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static Serializado.Data.videos;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sintoma;
import modelo.Turno;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SistemaPController implements Initializable {

    @FXML
    private Button btnRPaciente;

    @FXML
    private Button btnRDoctor;

    @FXML
    private Button btnCrearPuesto;

    @FXML
    private Button btnEliminarPuesto;
    @FXML
    private MediaView mediaView;

    @FXML
    private TableColumn<Turno,Cita> colTurno;
    @FXML
    private TableColumn<Puesto,Cita> colPuesto;
    @FXML
    public TableView<Cita> tbTurnoCita= new TableView<Cita>();
    
    private ObservableList<Cita> tableList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colTurno.setCellValueFactory(new PropertyValueFactory("turno"));
        colPuesto.setCellValueFactory(new PropertyValueFactory("puesto"));
        tbTurnoCita.setEditable(true);
        tableList = FXCollections.observableArrayList();
        Sintoma s = sintomas.get(2);
        Paciente p = new Paciente("Juan", "Gilces", 10, "masculino", s);
        Medico medico = new Medico("Jose", "PEPE", "Cardiolgo");
        Puesto puesto = new Puesto(2, medico);
        Turno turno = new Turno("A209", p);
        Cita c = new Cita(turno, puesto);
        tableList.add(c);
        tableList.add(c);
        tableList.add(c);
        tbTurnoCita.getItems().add(c);
        tbTurnoCita.setPlaceholder(new Text("Johan"));
        tbTurnoCita.setItems(tableList);
        new VisorVideos(mediaView).createMediaView(videos);
        new BotonesController(btnRPaciente, btnRDoctor, btnCrearPuesto, btnEliminarPuesto).setearbotones();
    }

}
