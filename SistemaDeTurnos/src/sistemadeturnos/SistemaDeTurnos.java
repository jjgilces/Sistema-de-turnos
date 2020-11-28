
package sistemadeturnos;

import Serializado.BaseDatos;
import fileReader.LectorSintomas;
import fileReader.LectorVideos;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Paciente;

/**
 *
 * @author user
 */
public class SistemaDeTurnos extends Application{

    /**
     * @param args the command line arguments
     */
    //Una lista estatica para la implementacion del metodo de abajo
    //Probablemente esto despues se mueva para una mejor implementacion del programa
    public static  List<Paciente> listaPacientes = new LinkedList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        BaseDatos.cargarPacientes();
        LectorSintomas.leerArchivo();
        LectorVideos.leerArchivoVideos();
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
    
    /*
    El siguiente metodo es solo para establacer la logica de la cola por prioridad en pacientes
    Su implementacion probablemente cambie.
    */
    public static void prueba(List<Paciente> listaPaciente){
        //Organizando por prioridad
        PriorityQueue<Paciente> colap = new PriorityQueue<>((Paciente p1, Paciente p2) -> p1.getPrioridad() - p2.getPrioridad());
        colap.addAll(listaPaciente);
        while(!colap.isEmpty()){
            Paciente p1 = colap.poll();
            System.out.println(p1);
        }
        
        
    }
}
