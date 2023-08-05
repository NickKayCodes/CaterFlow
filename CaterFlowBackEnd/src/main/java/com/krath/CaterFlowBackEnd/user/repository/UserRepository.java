package com.krath.CaterFlowBackEnd.user.repository;

import com.krath.CaterFlowBackEnd.user.enitity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.username  = :username")
    public User findByUserName(@Param("username") String username);

    @Query(value = "select u from User u where u.email = :email")
    public User findByEmail(@Param("email") String email);
}
