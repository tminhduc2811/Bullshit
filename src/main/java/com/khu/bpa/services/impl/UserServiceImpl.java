package com.khu.bpa.services.impl;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserCredentialsDTO;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.User;
import com.khu.bpa.repositories.UserRepository;
import com.khu.bpa.services.UserService;
import com.khu.bpa.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(RegisterFormDTO registerFormDTO) {
        User user = DTOMapper.mapObject(registerFormDTO, User.class);
        if (userRepository.isUsernameExist(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already existed");
        }
        if (userRepository.isEmailExist(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already existed");
        }
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllPatients() {
        return DTOMapper.mapList(userRepository.getAllPatients(), UserDTO.class);
    }

    @Override
    public String login(UserCredentialsDTO userCredentialsDTO) {
        return null;
    }
}
