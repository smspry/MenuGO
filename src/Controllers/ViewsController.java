package Controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewsController {

     public static void newScene(Stage stage, Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
