package com.astafiev.recipemanager.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "recipes")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_type_id")
    private RecipeType recipeType;

    private String label;

    private String description;

    private String instructions;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "comment_id")
    private List<Comment> comment;

    @OneToMany(
            mappedBy = "recipe",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )

    private List<RecipeIngredient> recipeIngredients = new ArrayList<>();

    public Recipe() {
    }

    public Recipe(RecipeType recipeType, @NonNull String label, @NonNull String description, @NonNull String instructions, User user, List<Comment> comment) {
        this.recipeType = recipeType;
        this.label = label;
        this.description = description;
        this.instructions = instructions;
        this.user = user;
        this.comment = comment;
    }
    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeType=" + recipeType +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                ", instructions='" + instructions + '\'' +
                ", user=" + user +
                ", comment=" + comment +
                //", recipeIngredients=" + recipeIngredients +
                '}';
    }


}
