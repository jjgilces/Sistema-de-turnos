package sistemadeturnos;

import Serializado.Alerta;
import TDA.CircularSimplyLinkedList;
import fileReader.CargarDatos;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Cita;
import modelo.Medico;
import modelo.Paciente;
import modelo.Puesto;
import modelo.Sintoma;

/**
 *
 * @author user
 */
public class SistemaDeTurnos extends Application {

    //Una lista estatica para la implementacion del metodo de abajo
    //Probablemente esto despues se mueva para una mejor implementacion del programa
    public static List<Sintoma> sintomas = new ArrayList<>();
    public static List<String> especialidades = new LinkedList<>();
    public static CircularSimplyLinkedList<String> videos = new CircularSimplyLinkedList<>();
    public static PriorityQueue<Paciente> pacientes = new PriorityQueue<>((Paciente p1, Paciente p2) -> p1.getSintoma().getPrioridad() - p2.getSintoma().getPrioridad());
    public static List<Medico> medicos = new LinkedList<>();
    public static PriorityQueue<Cita> citas = new PriorityQueue<>((Cita p1, Cita p2) -> p1.getTurno().getPaciente().getSintoma().getPrioridad() - p2.getTurno().getPaciente().getSintoma().getPrioridad());
    public static Queue<Puesto> puestosAsignados = new LinkedList<>();

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
        stage.setOnCloseRequest(e->{
            Optional<ButtonType> result = Alerta.confirmation();
            if(result.get()==ButtonType.OK){
//                pController.getrController().serializarListas();
                Platform.exit();
            }else{
                e.consume();
            }});
        }
}
