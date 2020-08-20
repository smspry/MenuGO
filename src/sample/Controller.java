package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button createMenu,viewMealList,createGroceryList,LazyFeature;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;

        if(event.getSource()==createMenu) {
            stage = (Stage) createMenu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("CreateMenu.fxml"));
        }
        else if(event.getSource()==viewMealList) {
            stage = (Stage) viewMealList.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ListOfMeals.fxml"));
        }
        else if(event.getSource()==createGroceryList) {
            stage = (Stage) createGroceryList.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("GroceryList.fxml"));
        }
        else {
            stage = (Stage) LazyFeature.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RandomMenu.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resources){
    }

}
