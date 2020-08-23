package DBAccess;

import Models.Ingredient;
import Models.Meal;
import Models.MealItem;
import Models.Quantity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MealAccess extends DBAccess{

    public void addMeal(ArrayList<String> data){
        String sql = "insert into Meal(" +
                "meal_name, recipe)" +
                "values (?, ?)";
        buildAndExecutePrepared(data, sql);
    }

    public int countRecords() {
        return super.countRecords("Meal");
    }
    /**
    public void editMeal(String meal_name, ArrayList<MealItem> mealItems) {

    }
     */

    /**
     * RECIPE TO STRING:
     * Ingredient Name + " " + Ingredient Category + " " +
     * Ingredient Quantity + " " + Quantity Unit
     */

    public String getRecipeByName(String mealName) {
        String sql = "SELECT * FROM Meal where meal_name = ?";
        //noinspection Convert2Diamond
        ArrayList<String> data = new ArrayList<String>();
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, mealName);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Meal> mealItems = new ArrayList<>();
            while (rs.next()) {
                return (rs.getString("recipe"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //in case it doesn't find any results
        return null;
    }

    public static void main(String[] args) {
        MealAccess ma = new MealAccess();
        Ingredient toAddI = new Ingredient("tendies", "meat");
        Quantity toAddQ = new Quantity("package", (float) 1);
        MealItem toAddItem = new MealItem(toAddI, toAddQ);
        ArrayList<MealItem> mealItems = new ArrayList<>();
        Meal meal = new Meal(mealItems);
        mealItems.add(toAddItem);
        ArrayList<String> data = new ArrayList<>();
        data.add("chicken tendies");
        String recipe = meal.recipeToString();
        data.add(recipe);
        ma.addMeal(data);
    }


}
