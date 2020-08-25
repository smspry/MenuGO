package MenuGO.Controllers;
import MenuGO.DBAccess.QuantityAccess;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//import javax.swing.text.html.TableView;
import java.io.IOException;
import java.util.ArrayList;

public class CreateMealController {

    @FXML
    private GridPane grid;

    @FXML
    private Button home, addIngredient, addMeal, done;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();

        if (event.getSource() == home) {
            stage = (Stage) home.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            root = loader.load();
            newScene(stage, root);
        }
        else if (event.getSource() == addIngredient){
            addInputRow();
        }
        else if (event.getSource() == addMeal){
            stage = (Stage) addMeal.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("CreateMeal.fxml"));
            root = loader.load();
            newScene(stage, root);
        }
        else if (event.getSource() == done){
            stage = (Stage) done.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("ListOfMeals.fxml"));
            root = loader.load();
            newScene(stage, root);
        }

    }

    private void newScene(Stage stage, Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private GridPane addInputRow() {
        TextField ingredient= new TextField();
        ingredient.setPromptText("Chicken, peppers, etc...");
        TextField quantity = new TextField();
        quantity.setPromptText("1, 10, 1/4, etc...");
        ChoiceBox measurement = new ChoiceBox();
        QuantityAccess na = new QuantityAccess();
        ArrayList<String> items = na.getAllQuantities();
        measurement.setItems(FXCollections.observableList(items));
        measurement.prefWidth(150.00);

        int rowNum = 4;
        grid.addRow(3);
        grid.add(ingredient, 0, rowNum);
        grid.add(quantity, 1, rowNum);
        grid.add(measurement, 2, rowNum);

        GridPane.setMargin(ingredient, new Insets(15));
        GridPane.setMargin(quantity, new Insets(15));
        GridPane.setMargin(measurement, new Insets(15));

        return grid;
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resources){
//    }
}
