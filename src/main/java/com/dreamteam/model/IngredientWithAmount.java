package com.dreamteam.model;

/**
 * Created by Michał on 2015-06-29.
 */
public class IngredientWithAmount {
    private int amount;
    private Ingredient ingredient;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
