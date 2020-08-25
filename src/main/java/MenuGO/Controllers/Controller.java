package MenuGO.Controllers;

import ViewsController;
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

public class Controller extends ViewsController implements Initializable{

    @FXML
    private Button createMenu,viewMealList,createGroceryList,lazyFeature;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws Exception {
        Stage stage = null;
        Parent root = null;

        if(event.getSource()==createMenu) {
            stage = (Stage) createMenu.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("CreateMenu.fxml"));
            ViewsController.newScene(stage, root);
        }
        else if(event.getSource()==viewMealList) {
            stage = (Stage) viewMealList.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("ListOfMeals.fxml"));
            ViewsController.newScene(stage, root);
        }
        else if(event.getSource()==createGroceryList) {
            stage = (Stage) createGroceryList.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("GroceryList.fxml"));
            ViewsController.newScene(stage, root);

        }
        else if(event.getSource()==lazyFeature) {
            stage = (Stage) lazyFeature.getScene().getWindow();
            root = FXMLLoader.load(getClass().getClassLoader().getResource("RandomMenu.fxml"));
            ViewsController.newScene(stage, root);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resources){
    }

}
