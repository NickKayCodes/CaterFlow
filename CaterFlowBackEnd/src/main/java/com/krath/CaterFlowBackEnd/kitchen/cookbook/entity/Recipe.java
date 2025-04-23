//package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;
//
//import com.krath.CaterFlowBackEnd.kitchen.menu.entity.CFMenu;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.time.Duration;
//
//@Entity
//public class Recipe {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//    private String description;
//    private String instructions;
//    @Convert(converter = DurationConverter.class)
//    private Duration prepTime;
//    @Convert(converter = DurationConverter.class)
//    private Duration cookTime;
//    @Convert(converter = DurationConverter.class)
//    private Duration totalTime;
//    private int servings;
//    //need to associate the recipe -> menu relationship
//    //@ManyToOne
//   // @JoinColumn(name = "menu_id")
//   // private CFMenu menu;
//
//
//    public Recipe() {
//    }
//
//    public Recipe(long id, String name, String description, String instructions, Duration prepTime, Duration cookTime, Duration totalTime, int servings) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.instructions = instructions;
//        this.prepTime = prepTime;
//        this.cookTime = cookTime;
//        this.totalTime = totalTime;
//        this.servings = servings;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setInstructions(String instructions) {
//        this.instructions = instructions;
//    }
//
//    public void setPrepTime(Duration prepTime) {
//        this.prepTime = prepTime;
//    }
//
//    public void setCookTime(Duration cookTime) {
//        this.cookTime = cookTime;
//    }
//
//    public void setTotalTime(Duration totalTime) {
//        this.totalTime = totalTime;
//    }
//
//    public void setServings(int servings) {
//        this.servings = servings;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getInstructions() {
//        return instructions;
//    }
//
//    public Duration getPrepTime() {
//        return prepTime;
//    }
//
//    public Duration getCookTime() {
//        return cookTime;
//    }
//
//    public Duration getTotalTime() {
//        return totalTime;
//    }
//
//    public int getServings() {
//        return servings;
//    }
//}
