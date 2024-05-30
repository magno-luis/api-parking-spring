package com.dev.api.controllers;

import com.dev.api.controllers.dtos.LoginRequest;
import com.dev.api.controllers.dtos.LoginResponse;
import com.dev.api.exception.AuthenticationException;
import com.dev.api.impl.AuthServiceImpl;
import com.dev.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthServiceImpl authServiceImpl;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        try {
            var result = authServiceImpl.login(loginRequest);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        }catch (AuthenticationException e){
            throw new AuthenticationException("Email ou senha inválidos!");
        }
    }

}
