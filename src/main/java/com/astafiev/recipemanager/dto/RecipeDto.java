package com.astafiev.recipemanager.dto;

import java.util.ArrayList;
import java.util.List;

public class RecipeDto {

        private Long recipeTypeId;
        private String label;
        private String description;
        private String instructions;
        private Long userId;
        private List<RecipeIngredientDto> recipeIngredientIds = new ArrayList<>();

        public void setLabel(String label) {
                this.label = label;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getInstructions() {
                return instructions;
        }

        public void setInstructions(String instructions) {
                this.instructions = instructions;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public List<RecipeIngredientDto> getRecipeIngredientIds() {
                return recipeIngredientIds;
        }

        public void setRecipeIngredientIds(List<RecipeIngredientDto> recipeIngredientIds) {
                this.recipeIngredientIds = recipeIngredientIds;
        }

        public String getLabel() {
                return label;
        }

        public Long getRecipeTypeId() {
                return recipeTypeId;
        }
}
