package com.khu.bpa.services;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserCredentialsDTO;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    List<UserDTO> getAllPatients();

    String login(UserCredentialsDTO userCredentialsDTO);

}
