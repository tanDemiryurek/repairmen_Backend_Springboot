package com.group21.repairmenService.dto;

import com.group21.repairmenService.enums.UserRole;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;

}
