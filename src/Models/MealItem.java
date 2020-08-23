package Models;

import java.util.ArrayList;

public class MealItem {
    private Ingredient ingredient;
    private Quantity quantity;

    public MealItem(Ingredient ingredient, Quantity quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public String getIngredientName() { return ingredient.getName();}

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
