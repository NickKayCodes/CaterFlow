package com.krath.CaterFlowBackEnd.user.service;

import com.krath.CaterFlowBackEnd.user.enitity.User;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        //unsure whether I want server or angular app to handle email validation... will have to decide in future
        return userRepository.findByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
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
        try{
            if(user.isPresent()){
                userRepository.deleteById(id);
            }
        }catch(Exception e){
            throw new IllegalArgumentException("User_Not_Found");
        }

    }
}
