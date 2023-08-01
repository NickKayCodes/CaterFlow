package com.krath.CaterFlowBackEnd.user.controller;

import com.krath.CaterFlowBackEnd.sec.PasswordEncoder;
import com.krath.CaterFlowBackEnd.user.enitity.User;
import com.krath.CaterFlowBackEnd.user.enums.UserRole;
import com.krath.CaterFlowBackEnd.user.repository.UserRepository;
import com.krath.CaterFlowBackEnd.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

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

        //save user and assigned roles to db
        userRepository.save(savedUser);

        return ResponseEntity.ok("User successfully registered");
    }

    //re-assigns roles when in specific user details screen ---unsure about the actual name of that kind of page
    //will probably refactor for an update user method.
    @PostMapping("/assignroles")
    public ResponseEntity assignUserRoles(@RequestBody User userWithRoles) {
        Set<UserRole> rolesToAssign = userWithRoles.getRoles();
        Optional<User> existingUser = userRepository.findById(userWithRoles.getId());
        if (existingUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User Not Found");
        }
        User u = new User();
        u = existingUser.get();

        userService.saveUser(u);

        return ResponseEntity.ok("User roles are successfully assigned.");
    }
}
