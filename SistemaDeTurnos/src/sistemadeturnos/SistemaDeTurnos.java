
package sistemadeturnos;

import fileReader.LectorArchivo;
import fileReader.LectorSintomas;
import fileReader.LectorVideos;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Sintoma;

/**
 *
 * @author user
 */
public class SistemaDeTurnos extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LectorSintomas.leerArchivo();
        LectorVideos.leerArchivoVideos();
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Atencion.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("SISTEMA DE CITAS");
        stage.setScene(scene);
        stage.show();
    }
}
