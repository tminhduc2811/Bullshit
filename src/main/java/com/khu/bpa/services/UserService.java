package com.khu.bpa.services;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserCredentialsDTO;
import com.khu.bpa.DTO.UserDTO;

import java.util.List;

public interface UserService {
    void registerUser(RegisterFormDTO registerFormDTO);

    List<UserDTO> getAllPatients();

    String login(UserCredentialsDTO userCredentialsDTO);

}
