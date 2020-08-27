import MenuGO.DBAccess.MealAccess;
import MenuGO.Models.Ingredient;
import MenuGO.Models.Meal;
import MenuGO.Models.MealItem;
import MenuGO.Models.Quantity;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MealAccess ma = new MealAccess();
        Ingredient toAddI = new Ingredient("Bread", "bread");
        Quantity toAddQ = new Quantity("loaf", (float) 1);
        MealItem toAddItem = new MealItem(toAddI, toAddQ);
        ArrayList<MealItem> mealItems = new ArrayList<>();
        Meal meal = new Meal("Bread meal",mealItems);
        mealItems.add(toAddItem);
        meal.addMealToDB();
        System.out.println("hello there");
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello Bedtime");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
