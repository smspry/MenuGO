package MenuGO.Models;

import java.util.ArrayList;

public class GroceryList {
    ArrayList<MealItem> mealItems;

    public GroceryList(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public ArrayList<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public void exportList(Menu menu) {

    }
}
