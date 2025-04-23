package com.krath.CaterFlowBackEnd.user.service;


import com.krath.CaterFlowBackEnd.user.entity.User;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {
    void saveUser(User user);

    User getUserByEmail(String email);

    void updateUser(User user);

    List<User> getAllUsers();

    void removeUser(long id); // May change how looking up user for removal will look.

    //role management
    boolean roleExist(UserRole role);

    void assignRolesToUser(User user, Set<UserRole> roles);

    User findByUsername(String username);

}
