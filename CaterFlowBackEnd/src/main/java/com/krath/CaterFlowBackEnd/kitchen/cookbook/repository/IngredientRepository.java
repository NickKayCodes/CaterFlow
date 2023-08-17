package com.krath.CaterFlowBackEnd.kitchen.cookbook.repository;

import com.krath.CaterFlowBackEnd.kitchen.cookbook.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Long, Ingredient> {

    //finding singular ingredient
    @Query(value = "select i from Ingredient i where i.name = :name")
    Ingredient findByName(@Param("name") String name);

}
