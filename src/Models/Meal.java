package Models;

import java.util.ArrayList;

public class Meal {

    private ArrayList<MealItem> mealItems;
    private boolean isEmpty;

    public Meal(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
    }

    public Meal(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public ArrayList<MealItem> getMealItems() {
        return mealItems;
    }

    public void setMealItems(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
        this.isEmpty = false;
    }

    public boolean getEmpty() {
        return isEmpty;
    }
}
