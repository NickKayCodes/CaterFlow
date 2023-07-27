package com.krath.CaterFlowBackEnd.user.service;

import com.krath.CaterFlowBackEnd.user.enitity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    User getUserByEmail(String email);
    void updateUser(User user);
    List<User> getAllUsers();
    void removeUser(long id); // May change how looking up user for removal will look.

}
