//package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;
//
//import jakarta.persistence.*;
//
//
//@Entity
//public class RecipeInstruction {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    //actual instructions to each recipe in steps
//    private String description;
//
//    //RecipeInstruction to Recipe relationship
//    //@ManyToOne
//    //@JoinColumn(name = "recipe_id")
//   // private Recipe recipe;
//
//
//    public RecipeInstruction() {
//    }
//
//    public RecipeInstruction(long id, String description) {
//        this.id = id;
//        this.description = description;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//}
