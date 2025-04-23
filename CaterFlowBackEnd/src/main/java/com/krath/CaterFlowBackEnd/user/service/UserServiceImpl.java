package com.krath.CaterFlowBackEnd.user.service;

import com.krath.CaterFlowBackEnd.user.entity.User;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;

import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        // Encode password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if (optionalUser.isPresent()) {
            User updateUser = optionalUser.get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setEmail(user.getEmail());

            // Encode password if it's updated
            if (user.getPassword() != null && !user.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(user.getPassword());
                updateUser.setPassword(encodedPassword);
            }

            userRepository.save(updateUser);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
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
        user.getRoles().clear();
        user.getRoles().addAll(roles);
        userRepository.save(user);
        logger.info("Roles assigned to user: {}", user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
