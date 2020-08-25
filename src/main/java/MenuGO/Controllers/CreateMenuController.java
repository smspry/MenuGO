package MenuGO.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateMenuController extends ViewsController implements Initializable{

    @FXML
    private Button home;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();

        if (event.getSource() == home) {
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
