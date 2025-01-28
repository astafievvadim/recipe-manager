package com.astafiev.recipemanager.dtos;

import com.astafiev.recipemanager.model.Comment;
import com.astafiev.recipemanager.model.RecipeIngredient;
import com.astafiev.recipemanager.model.RecipeType;
import com.astafiev.recipemanager.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecipeDTO {

        private Long recipeTypeId;

        private String label;

        private String description;

        private String instructions;

        private Long userId;

        private List<RecipeIngredientDTO> recipeIngredientIds = new ArrayList<>();


        public RecipeDTO(Long recipeTypeId, String label, String description, String instructions, Long userId, List<RecipeIngredientDTO> recipeIngredientIds) {
                this.recipeTypeId = recipeTypeId;
                this.label = label;
                this.description = description;
                this.instructions = instructions;
                this.userId = userId;
                this.recipeIngredientIds = recipeIngredientIds;
        }

        public RecipeDTO() {
        }

        public Long getRecipeTypeId() {
                return recipeTypeId;
        }

        public void setRecipeTypeId(Long recipeTypeId) {
                this.recipeTypeId = recipeTypeId;
        }

        public String getLabel() {
                return label;
        }

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

        public List<RecipeIngredientDTO> getRecipeIngredientIds() {
                return recipeIngredientIds;
        }

        public void setRecipeIngredientIds(List<RecipeIngredientDTO> recipeIngredientIds) {
                this.recipeIngredientIds = recipeIngredientIds;
        }
}
