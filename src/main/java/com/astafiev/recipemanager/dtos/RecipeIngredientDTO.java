package com.astafiev.recipemanager.dtos;

public class RecipeIngredientDTO {

    private Long ingredientId;

    private double amount;

    private Long unitId;

    public RecipeIngredientDTO(Long ingredientId, double amount, Long unitId) {
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unitId = unitId;
    }

    public RecipeIngredientDTO() {
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }
}
