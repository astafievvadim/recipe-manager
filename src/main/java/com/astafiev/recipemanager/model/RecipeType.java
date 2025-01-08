package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name="recipe_types")
public class RecipeType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String label;
    @NonNull
    private String description;

    public RecipeType() {
    }

    public RecipeType(@NonNull String label, @NonNull String description) {

        this.label = label;
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    @NonNull
    public String getLabel() {
        return label;
    }


    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

}
