package com.krath.CaterFlowBackEnd.user.controller;

import com.krath.CaterFlowBackEnd.sec.PasswordEncoder;
import com.krath.CaterFlowBackEnd.user.enitity.Roles;
import com.krath.CaterFlowBackEnd.user.enitity.User;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import com.krath.CaterFlowBackEnd.user.service.roles.RolesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RolesServiceImpl rolesService;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User userData) {
        User user = userRepository.findByUserName(userData.getUserName());
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
        String plainTextPw = userData.getPassword();
        String encodedPw = passwordEncoder.encodePassword(plainTextPw);
        userData.setPassword(encodedPw);

        //save user without roles first we will assign roles below
        User savedUser = userRepository.save(userData);

        //after user is saved we will grab the auto generated userId
        Long userId = savedUser.getId();

        //grab roles from request body
        List<Roles> rolesList = userData.getRoles();
        //check if the role assignment is not empty and not null
        if (rolesList != null && !rolesList.isEmpty()) {
            //create a temp roles list
            List<Roles> savedRoles = new ArrayList<>();

            //iterate through rolesList
            rolesList.forEach(role -> {
                //find each roll name
                Roles existingRole = rolesService.findByName(role.getRoleName());
                if (existingRole != null) {
                    savedRoles.add(existingRole);

                } else {
                    //save the role ang get either the existing role or the newly saved role
                    Roles newRoles = rolesService.saveRole(role);
                    savedRoles.add(newRoles);
                }
            });

            //set the list of roles to the user after using the auto-generated userId
            savedUser.setRoles(savedRoles);

            //save user and assigned roles to db
            userRepository.save(savedUser);


        }


        return ResponseEntity.ok("User successfully registered");
    }
}
