//package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//@Entity
//public class RecipeIngredient {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    //@ManyToOne
//    //@JoinColumn(name = "recipe_id")
//    //private Recipe recipe;
//
//    //@ManyToOne
//    //@JoinColumn(name = "ingredient_id")
//    //private Ingredient ingredient;
//
//    private double amount; //amount of ingredients
//
//    //@ManyToOne
//    //@JoinColumn(name = "measurement_id")
//    //private Measurement measurement;
//
//
//    public RecipeIngredient() {
//    }
//
//    public RecipeIngredient(long id, double amount) {
//        this.id = id;
//        this.amount = amount;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//}
