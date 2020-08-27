package MenuGO.Models;

import MenuGO.DBAccess.MealAccess;

import java.util.ArrayList;

public class Meal {

    private String mealName;
    private ArrayList<MealItem> mealItems;
    private boolean isEmpty;

    public Meal(String mealName, ArrayList<MealItem> mealItems) {
        this.mealName = mealName;
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

    /** FUNC: stringToRecipe
     * Call this function to turn the db representation of a meal back into its components (MealItem list)
     *
     * @param recipe string that contains serialized version of the recipe
     * @return ArrayList of the meal Items that make up this serialized recipe
     */
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

    /**
     * Call this function on a meal to add it to the database
     * It will collect its recipe, serialize it according to the rule
     * And add it to the database
     * @return void
     */
    public void addMealToDB() {
        MealAccess ma = new MealAccess();
        ArrayList<String> dbData = new ArrayList<>();
        dbData.add(this.mealName);
        dbData.add(this.recipeToString());
        ma.addMeal(dbData);
    }
}
