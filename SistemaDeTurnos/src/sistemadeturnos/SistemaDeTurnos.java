
package sistemadeturnos;

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
        Sintoma.llenarSintomas();
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FormularioDr.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        Parent root = FXMLLoader.load(getClass().getResource("/vista/FormularioPaciente.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("SISTEMA DE CITAS");
        stage.setScene(scene);
        stage.show();
    }
}
