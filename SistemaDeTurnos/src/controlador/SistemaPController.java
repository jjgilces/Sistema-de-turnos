package controlador;

import java.io.File;
import java.io.IOException;
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
import static sistemadeturnos.Data.videos;

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

    }

    @FXML
    public void newWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioDr.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Formulario Doctor");
        stage.setScene(scene);
        stage.show();
    }

    public void cambioVentanaPaciente(ActionEvent e) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioPaciente.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Formulario Paciente");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SistemaPController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
