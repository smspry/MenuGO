package MenuGO.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListOfMealsController extends ViewsController implements Initializable {

    @FXML
    private Button addNewMeal,home;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        FXMLLoader loader = new FXMLLoader();

        if(event.getSource()==addNewMeal) {
            stage = (Stage) addNewMeal.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("CreateMeal.fxml"));
            root = loader.load();
            ViewsController.newScene(stage, root);
        }
        else{
            stage = (Stage) home.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            root = loader.load();
            ViewsController.newScene(stage, root);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resources){
    }

}