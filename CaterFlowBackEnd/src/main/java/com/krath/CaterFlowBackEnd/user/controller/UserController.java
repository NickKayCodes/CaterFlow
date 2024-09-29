package com.krath.CaterFlowBackEnd.user.controller;

import com.krath.CaterFlowBackEnd.sec.SecurityConfig;
import com.krath.CaterFlowBackEnd.user.enitity.User;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import com.krath.CaterFlowBackEnd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfig passwordEncoder;

    @Autowired
    private UserService userService;

    public UserController() {
    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User userData) {
        User user = userRepository.findByUserName(userData.getUsername());
        if (user != null) {
            if (passwordEncoder.passwordMatch(userData.getPassword(), user.getPassword()))
                return ResponseEntity.ok(user);
        }
        return new ResponseEntity(
                "Login failure.",
                HttpStatus.BAD_REQUEST
        );
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User userData) {
        //grab password from front end, encode using bcrypt and then set the encrypted password to store
        if (userData.getPassword() == null || userData.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be null or empty.");
        }

        String plainTextPw = userData.getPassword();
        String encodedPw = passwordEncoder.encodePassword(plainTextPw);
        userData.setPassword(encodedPw);

        //save user before assigning roles due to jpa/hibernate not generating the id to enter the roles to the db
//        User savedUser =
        userRepository.save(userData);

        //retrieve user from db since now there will be an ID associated with the user
//        Optional<User> retrieveUser = userRepository.findById(savedUser.getId());
//        if (retrieveUser.isPresent()) {
//            Set<UserRole> rolesToAssign = userData.getRoles();
//
//            User u = retrieveUser.get();
//            userService.assignRolesToUser(u, rolesToAssign);
//        }

        return ResponseEntity.ok("User successfully registered");
    }
}
