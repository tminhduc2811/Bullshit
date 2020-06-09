package com.khu.bpa.DTO;

import com.khu.bpa.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
public class BpInfoDto {

    private Long id;

    private Integer systolic;

    private Integer diastolic;

    private Integer heartRate;

    private String username;
}
