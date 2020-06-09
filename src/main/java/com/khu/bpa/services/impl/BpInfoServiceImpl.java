package com.khu.bpa.services.impl;

import com.khu.bpa.DTO.BpInfoDto;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.entities.BpInfo;
import com.khu.bpa.entities.User;
import com.khu.bpa.repositories.BpInfoRepository;
import com.khu.bpa.repositories.UserRepository;
import com.khu.bpa.services.BpInfoService;
import com.khu.bpa.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BpInfoServiceImpl implements BpInfoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BpInfoRepository bpInfoRepository;

    @Override
    @Transactional
    public void modifyBpInfo(String username, BpInfoDto bpInfoDto) {
        User user = userRepository.getUserByUsername(username);
        BpInfo bpInfo = bpInfoRepository.getBpInfoByUsername(username);
        if (bpInfo == null) {
            bpInfo = new BpInfo();
        }
        bpInfo.setUser(user);
        bpInfo.setDiastolic(bpInfoDto.getDiastolic());
        bpInfo.setHeartRate(bpInfoDto.getHeartRate());
        bpInfo.setSystolic(bpInfoDto.getSystolic());
        user.setBpInfo(bpInfo);
        userRepository.save(user);

    }

    @Override
    public BpInfoDto getBpInfoByUsername(String username) {

        BpInfo bpInfo = bpInfoRepository.getBpInfoByUsername(username);
        return DTOMapper.mapObject(bpInfo, BpInfoDto.class);
    }

    @Override
    public List<UserDTO> getBpInfoOfAllUsers() {
        List<User> patients = userRepository.getAllPatients();
        return DTOMapper.mapList(patients, UserDTO.class);
    }
}
