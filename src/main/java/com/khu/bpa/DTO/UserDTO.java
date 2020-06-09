package com.khu.bpa.DTO;

import com.khu.bpa.entities.BpInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class UserDTO {
    private Long id;

    private String username;

    private String email;

    private String role;

    private String fullName;

    private String avatar;

    private String address;

    private String phoneNumber;

    private Short gender;

    private LocalDate birthday;

    private BpInfoDto bpInfo;
}
