package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long recipeId;

    @NotNull
    @ManyToOne
    private RecipeType recipeType;

    @NonNull
    private String label;

    @NonNull
    private String description;

    @NonNull
    private String instructions;

    private User user;

    private List<Comment> comment;

    public Recipe() {
    }

    public Recipe(Long recipeId, RecipeType recipeType, @NonNull String label, @NonNull String description, @NonNull String instructions, User user, List<Comment> comment) {
        this.recipeId = recipeId;
        this.recipeType = recipeType;
        this.label = label;
        this.description = description;
        this.instructions = instructions;
        this.user = user;
        this.comment = comment;
    }

    public long getRecipe_id() {
        return recipeId;
    }

    public void setRecipe_id(long recipeId) {
        this.recipeId = recipeId;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(@NonNull String instructions) {
        this.instructions = instructions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
