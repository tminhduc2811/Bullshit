package com.khu.bpa.controllers;

import com.khu.bpa.DTO.BpInfoDto;
import com.khu.bpa.DTO.UserDTO;
import com.khu.bpa.services.BpInfoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BpInfoController {

    @Autowired
    private BpInfoService bpInfoService;

    @GetMapping("/bpinfo/{username}")
    ResponseEntity<BpInfoDto> getPatientsBpInfo(@PathVariable("username") String username) {
        return new ResponseEntity<>(bpInfoService.getBpInfoByUsername(username), HttpStatus.OK);
    }

    @PostMapping("/bpinfo/{username}")
    ResponseEntity<Void> updateBpInfo(@PathVariable("username") String username, @RequestBody BpInfoDto bpInfoDto) {
        bpInfoService.modifyBpInfo(username, bpInfoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bpinfo/all")
    ResponseEntity<List<UserDTO>> getPatientsBpInfo() {
        return new ResponseEntity<>(bpInfoService.getBpInfoOfAllUsers(), HttpStatus.OK);
    }

}
