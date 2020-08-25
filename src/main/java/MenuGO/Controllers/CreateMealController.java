package MenuGO.Controllers;
import MenuGO.DBAccess.QuantityAccess;
import MenuGO.Controllers.ViewsController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

//import javax.swing.text.html.TableView;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateMealController extends ViewsController{

    private int addRowCounter = 0;

    @FXML
    private GridPane grid;

    @FXML
    private Button home, addIngredient, addMeal, save;

    @FXML
    private void buttonPressedEvent(ActionEvent event) throws IOException {

        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = new FXMLLoader();

        if (event.getSource() == home) {
            stage = (Stage) home.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("sample.fxml"));
            root = loader.load();

            addRowCounter = 0;
            ViewsController.newScene(stage, root);
        }
        else if (event.getSource() == addIngredient){
            addInputRow(addRowCounter);
            addRowCounter++;
        }
        else if (event.getSource() == addMeal){
            stage = (Stage) addMeal.getScene().getWindow();
            loader.setLocation(getClass().getClassLoader().getResource("CreateMeal.fxml"));
            root = loader.load();

            addRowCounter = 0;
            ViewsController.newScene(stage, root);
        }
        else if (event.getSource() == save){
            addRowCounter = 0;
            stage = (Stage) save.getScene().getWindow();
                loader.setLocation(getClass().getClassLoader().getResource("ListOfMeals.fxml"));
            root = loader.load();
            ViewsController.newScene(stage, root);
        }
    }

    private GridPane addInputRow(int addRowCounter) {
        // creating children in for the new row
        TextField ingredient= new TextField();
        ingredient.setPromptText("Chicken, peppers, etc...");

        TextField quantity = new TextField();
        quantity.setPromptText("1, 10, 1/4, etc...");

        ComboBox measurement = new ComboBox<Array>();
        measurement.setPrefWidth(150.00);
        QuantityAccess na = new QuantityAccess();
        ArrayList<String> items = na.getAllQuantities();
        measurement.setItems(FXCollections.observableList(items));

        // setting up additional row
        RowConstraints newRow = new RowConstraints();
        newRow.setPrefHeight(40);
        newRow.setValignment(VPos.CENTER);
        newRow.setVgrow(Priority.NEVER);

        int rowNum = 4 + addRowCounter;
        grid.addRow(3 + addRowCounter);
        grid.getRowConstraints().addAll(newRow);
        grid.add(ingredient, 0, rowNum);
        grid.add(quantity, 1, rowNum);
        grid.add(measurement, 2, rowNum);

        GridPane.setMargin(ingredient, new Insets(15));
        GridPane.setMargin(quantity, new Insets(15));
        GridPane.setMargin(measurement, new Insets(15));

        return grid;
    }
}
