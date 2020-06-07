package com.khu.bpa.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class RegisterFormDTO {
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String role;
    private String address;
    private String phoneNumber;
    private Short gender;
    private LocalDate birthday;
}
