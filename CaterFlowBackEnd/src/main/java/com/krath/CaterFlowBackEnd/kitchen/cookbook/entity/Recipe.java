package com.krath.CaterFlowBackEnd.kitchen.cookbook.entity;

import com.krath.CaterFlowBackEnd.kitchen.menu.entity.CFMenu;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String instructions;
    private Duration prepTime;
    private Duration cookTime;
    private Duration totalTime;
    private int servings;
    //need to associate the recipe -> menu relationship
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private CFMenu menu;
}
