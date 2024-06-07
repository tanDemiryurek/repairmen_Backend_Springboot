package com.group21.repairmenService.entity;

import com.group21.repairmenService.dto.UserDto;
import com.group21.repairmenService.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private String lastname;

    private String phone;

    private UserRole role;


    public UserDto getDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setName(name);
        userDto.setLastname(lastname);
        userDto.setEmail(email);
        userDto.setPhone(phone);
        userDto.setRole(role);

        return userDto;
    }
}
