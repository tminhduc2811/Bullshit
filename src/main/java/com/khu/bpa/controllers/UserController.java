package com.khu.bpa.controllers;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<Void> registerUser(@RequestBody RegisterFormDTO registerFormDTO) {
        userService.registerUser(registerFormDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
