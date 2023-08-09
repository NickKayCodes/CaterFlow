package com.krath.CaterFlowBackEnd.kitchen.cookbook.repository;

import com.krath.CaterFlowBackEnd.kitchen.cookbook.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Long, Recipe> {
    @Query(value = "select r from Recipe r where r.name = :name")
    public Recipe findByName(@Param("name") String Name);


}
