package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecipeInstruction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //actual instructions to each recipe in steps
    private String description;

    //RecipeInstruction to Recipe relationship
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
