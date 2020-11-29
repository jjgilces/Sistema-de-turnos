package controlador;


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
import javafx.scene.control.Alert;

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

    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new VisorVideos(mediaView).createMediaView(videos);
        new BotonesController(btnRPaciente, btnRDoctor, btnCrearPuesto, btnEliminarPuesto).setearbotones();
    }
    public static void mostrarAlerta(String mensaje, Alert.AlertType e){
            Alert alert = new Alert(e);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
    }

}
