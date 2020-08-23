package Controllers;
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

public class RandomMenuController {

    @FXML
    private Button home;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();

        if (event.getSource() == home) {
            stage = (Stage) home.getScene().getWindow();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            root = loader.load();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resources){
//    }
}
