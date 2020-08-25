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

public class ListOfMealsController implements Initializable {

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
        }
        else{
            stage = (Stage) home.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            root = loader.load();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resources){
    }

}