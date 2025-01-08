package com.astafiev.recipemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class RecipeIngredientId implements Serializable {

    @Column(name = "recipe_id")
    Long recipeId;

    @Column(name = "ingredient_id")
    Long ingredientId;

    @Column(name = "unit_id")
    Long unitId;

}
