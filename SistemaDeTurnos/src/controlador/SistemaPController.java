package controlador;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.MediaView;
import static controlador.Data.videos;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Cita;
import modelo.Puesto;
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
    public static TableView<Cita> tablaView ;
    private static ObservableList<Cita> tableElement;
    private TablaController controladorTabla = new TablaController(colTurno, colPuesto, tbTurnoCita);

    public TablaController getControladorTabla() {
        return controladorTabla;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new TablaController(colTurno, colPuesto, tbTurnoCita).mostrarTabla();
        new VisorVideos(mediaView).createMediaView(videos);
        new BotonesController(btnRPaciente, btnRDoctor, btnCrearPuesto, btnEliminarPuesto).setearbotones();
    }
}
