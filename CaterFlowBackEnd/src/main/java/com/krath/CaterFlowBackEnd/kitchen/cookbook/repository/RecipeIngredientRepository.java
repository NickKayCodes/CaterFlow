//package com.krath.CaterFlowBackEnd.kitchen.cookbook.repository;
//
//
//import com.krath.CaterFlowBackEnd.kitchen.cookbook.entity.Recipe;
//import com.krath.CaterFlowBackEnd.kitchen.cookbook.entity.RecipeIngredient;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
//
//    //may not work will have to fix this when everything falls together for the cookbook ui since recipe on the RecipeIngredient table is an id number
//    @Query(value = "select ri from RecipeIngredient ri where ri.recipe = :recipe")
//    RecipeIngredient findByRecipe(@Param("recipe") Recipe recipe);
//}
