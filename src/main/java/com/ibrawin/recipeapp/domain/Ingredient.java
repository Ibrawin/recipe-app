package com.ibrawin.recipeapp.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe", "unitOfMeasure"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "unit_of_measure_id")
    private UnitOfMeasure unitOfMeasure;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure unitOfMeasure) {
        this.description = description;
        this.amount = amount;
        this.unitOfMeasure = unitOfMeasure;
    }
}
