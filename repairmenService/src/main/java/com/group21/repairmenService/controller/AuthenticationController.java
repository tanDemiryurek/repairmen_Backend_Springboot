package com.group21.repairmenService.controller;

import com.group21.repairmenService.dto.AuthenticationRequest;
import com.group21.repairmenService.dto.SignupRequestDTO;
import com.group21.repairmenService.dto.UserDto;
import com.group21.repairmenService.entity.User;
import com.group21.repairmenService.repository.UserRepository;
import com.group21.repairmenService.services.authentication.AuthService;
import com.group21.repairmenService.services.jwt.UserDetailsServiceImpl;
import com.group21.repairmenService.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO){

        if (authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Bu E-posta adresi zaten bir kullanıcı tarafından kullanılmaktadır.", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupClient(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);

    }

    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO){

        if (authService.presentByEmail(signupRequestDTO.getEmail())){
            return new ResponseEntity<>("Bu E-posta adresi zaten bir şirket tarafından kullanılmaktadır.", HttpStatus.NOT_ACCEPTABLE);
        }

        UserDto createdUser = authService.signupCompany(signupRequestDTO);

        return new ResponseEntity<>(createdUser, HttpStatus.OK);

    }

    @PostMapping({"/authenticate"})
    public void createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest,
                                          HttpServletResponse response) throws IOException, JSONException {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()
            ));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Yanlış kullanıcı Adı ya da şifre", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        User user = userRepository.findFirstByEmail(authenticationRequest.getUsername());

        response.getWriter().write(new JSONObject()
                .put("userId", user.getId())
                .put("role", user.getRole())
                .toString());

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Authorization," +
                "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept, X-Custom-header");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX+jwt);
    }
}
