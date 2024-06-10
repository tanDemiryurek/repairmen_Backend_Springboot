package com.group21.repairmenService.services.authentication;

import com.group21.repairmenService.dto.SignupRequestDTO;
import com.group21.repairmenService.dto.UserDto;

public interface AuthService {
    UserDto signupClient(SignupRequestDTO signupRequestDTO);
    Boolean presentByEmail(String email);

    UserDto signupCompany(SignupRequestDTO signupRequestDTO);
    boolean changePassword(Long userId, String verifyPassword, String newPassword);
}
