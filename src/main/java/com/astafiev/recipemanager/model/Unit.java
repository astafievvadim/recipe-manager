package com.astafiev.recipemanager.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name = "units")
public class Unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String label;

    public Unit() {
    }

    public Unit(@NonNull String label) {

        this.label = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }
}
