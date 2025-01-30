package com.astafiev.recipemanager.dto;


public class RecipeIngredientDto {

    private Long ingredientId;
    private double amount;
    private Long unitId;

    public RecipeIngredientDto(Long ingredientId, double amount, Long unitId) {
        this.ingredientId = ingredientId;
        this.amount = amount;
        this.unitId = unitId;
    }

    public RecipeIngredientDto() {
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
