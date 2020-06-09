package com.khu.bpa.controllers;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserCredentialsDTO;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.User;
import com.khu.bpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/patients")
    ResponseEntity<List<UserDTO>> getAllPatients() {
        return new ResponseEntity<>(userService.getAllPatients(), HttpStatus.OK);
    }

    @PostMapping("/users/register")
    ResponseEntity<Void> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/users/login")
    ResponseEntity<Map<String, String>> loginUser(@RequestBody UserCredentialsDTO user) {
        return new ResponseEntity<>(Collections.singletonMap("token", userService.login(user)), HttpStatus.OK);
    }
}
