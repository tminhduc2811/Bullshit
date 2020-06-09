package com.khu.bpa.services.impl;

import com.khu.bpa.DTO.RegisterFormDTO;
import com.khu.bpa.DTO.UserCredentialsDTO;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.BpInfo;
import com.khu.bpa.entities.User;
import com.khu.bpa.repositories.UserRepository;
import com.khu.bpa.services.UserService;
import com.khu.bpa.util.DTOMapper;
import com.khu.bpa.util.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public void registerUser(User user) {
        if (userRepository.isUsernameExist(user.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already existed");
        }
        if (userRepository.isEmailExist(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already existed");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole().equals("PATIENT")) {
            BpInfo bpInfo = new BpInfo();
            bpInfo.setSystolic(0);
            bpInfo.setHeartRate(0);
            bpInfo.setDiastolic(0);
            bpInfo.setUser(user);
            user.setBpInfo(bpInfo);
        }
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllPatients() {
        return DTOMapper.mapList(userRepository.getAllPatients(), UserDTO.class);
    }

    @Override
    public String login(UserCredentialsDTO userCredentialsDTO) {
        try {

            Authentication authentication =
                    authenticationManager
                            .authenticate(
                                    new UsernamePasswordAuthenticationToken(
                                            userCredentialsDTO.getUsername(),
                                            userCredentialsDTO.getPassword()));

            return jwtTokenProvider.generateToken(authentication);
        } catch (AuthenticationException ex) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Authentication failed");
        }
    }
}
