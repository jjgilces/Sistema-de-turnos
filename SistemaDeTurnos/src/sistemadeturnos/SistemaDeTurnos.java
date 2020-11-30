
package sistemadeturnos;

import fileReader.CargarDatos;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Medico;
import modelo.Paciente;

/** 
 *
 * @author user
 */
public class SistemaDeTurnos extends Application{

    /**
     */
    //Una lista estatica para la implementacion del metodo de abajo
    //Probablemente esto despues se mueva para una mejor implementacion del programa
    public static  List<Paciente> listaPacientes = new LinkedList<>();
    public static  List<Medico> listaMedicos = new LinkedList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        CargarDatos.cargarArchivos();
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/SistemaP.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("SISTEMA DE CITAS");
        stage.setScene(scene);
        stage.show();
    }
}
