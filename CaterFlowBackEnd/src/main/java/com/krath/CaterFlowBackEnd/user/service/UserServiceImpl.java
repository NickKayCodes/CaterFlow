package com.krath.CaterFlowBackEnd.user.service;

import com.krath.CaterFlowBackEnd.user.enitity.User;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        //unsure whether I want server or angular app to handle email validation... will have to decide in future
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(long id) {
        Optional<User> user = userRepository.findById(id);
        try {
            if (user.isPresent()) {
                userRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("User_Not_Found");
        }

    }

    @Override
    public boolean roleExist(UserRole role) {
        List<UserRole> allRoles = Arrays.asList(UserRole.values());
        return allRoles.contains(role);
    }

    @Transactional
    @Override
    public void assignRolesToUser(User user, Set<UserRole> roles) {
//        logger.info("starting assignRolesToUser()| " + user + " | " + roles);
//        user.getRoles().removeAll(roles);
//
//        //since using an enum and UI will never have roles that does not exist we can just add the roles to the set directly
//        user.getRoles().addAll(roles);
//
//        userRepository.save(user);
//        logger.info("roles assigned to user complete: " + user);
    }
}
