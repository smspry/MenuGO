package MenuGO.Models;

import java.util.ArrayList;

public class Meal {

    private ArrayList<MealItem> mealItems;
    private boolean isEmpty;

    public Meal(ArrayList<MealItem> mealItems) {
        this.mealItems = mealItems;
        if (mealItems.size() > 0) {
            isEmpty = false;
        }
        else {
            isEmpty = true;
        }
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

    public String recipeToString() {
        StringBuilder recipeString = new StringBuilder();
        if (mealItems.size() == 0) {
            return "";
        }
        for (int i = 0; i < mealItems.size(); i ++) {
            MealItem cur = mealItems.get(i);
            recipeString.append(cur.getIngredientName());
            recipeString.append(" ");
            recipeString.append(cur.getIngredient().getCategory());
            recipeString.append(" ");
            recipeString.append(cur.getQuantity().getAmount());
            recipeString.append(" ");
            recipeString.append(cur.getQuantity().getUnit());
            recipeString.append(" ");
        }
        //slice off the last character
        return recipeString.toString().substring(0, recipeString.length()-1);
    }

    public static ArrayList<MealItem> stringToRecipe(String recipe) {
        ArrayList<MealItem> recipeItems = new ArrayList<MealItem>();
        String[] splitRecipe = recipe.split("\\s+");
        int numItems = splitRecipe.length/4;
        int currentInd;
        for (int i = 0; i < numItems; i++) {
            currentInd = i*4;
            Ingredient toAddI = new Ingredient(splitRecipe[currentInd], splitRecipe[currentInd+1]);
            Quantity toAddQ = new Quantity(splitRecipe[currentInd+2], Float.parseFloat(splitRecipe[currentInd+3]));
            recipeItems.add(new MealItem(toAddI, toAddQ));
        }
        return recipeItems;
    }
}
