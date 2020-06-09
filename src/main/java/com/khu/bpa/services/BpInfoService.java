package com.khu.bpa.services;

import com.khu.bpa.DTO.BpInfoDto;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.BpInfo;

import java.util.List;

public interface BpInfoService {
    void modifyBpInfo(String username, BpInfoDto bpInfoDto);

    BpInfoDto getBpInfoByUsername(String username);

    List<UserDTO> getBpInfoOfAllUsers();
}
