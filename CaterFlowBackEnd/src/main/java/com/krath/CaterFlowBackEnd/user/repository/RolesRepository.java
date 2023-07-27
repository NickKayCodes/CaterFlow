package com.krath.CaterFlowBackEnd.user.repository;

import com.krath.CaterFlowBackEnd.user.enitity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

    @Query(value = "Select r from Roles r where r.roleName = :roleName")
    public Roles findByName(@Param("roleName") String roleName);

}
