
package controlador;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
//        MediaPlayer mediaPlayer = new MediaPlayer(new Media(((getClass().getResource("/vista/SistemaP.fxml"))).toURI().toString()));
          String file = this.getClass().getResource("/recursos/videos/video1.mp4").toExternalForm();
          Media media = new Media(file);
          mediaPlayer = new MediaPlayer(media);
//        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("video1.mp4").toExternalForm()));
          mediaPlayer.setAutoPlay(true);
          mediaView.setMediaPlayer(mediaPlayer);
 
    }    
    
    @FXML
    void newWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioDr.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Formulario Doctor");
        stage.setScene(scene);
        stage.show();
    }

   
}
