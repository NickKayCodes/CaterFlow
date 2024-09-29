package com.krath.CaterFlowBackEnd.kitchen.menu.repository;

import com.krath.CaterFlowBackEnd.kitchen.menu.entity.CFMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CFMenuRepository extends JpaRepository<CFMenu, Long> {

    @Query(value = "select m from CFMenu m where m.dishName = :dishName")
    CFMenu dishName(@Param("dishName") String dishName);

    @Query(value = "select m from CFMenu m where m.price = :price")
    List<CFMenu> menuListByPrice(@Param("price") double Price);

    @Query(value = "select m from CFMenu m where m.season = :season")
    List<CFMenu> menuBySeason(@Param("season") String Season);

}