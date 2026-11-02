package com.lesi.rpg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lesi.rpg.dto.AuthResponseDto;
import com.lesi.rpg.entity.User;
import com.lesi.rpg.service.UserService;

@RestController 
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping ("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User savedUser = userService.registerUser(user);

        savedUser.setPassword(null);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody User loginRequest){
        String token = userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        
        AuthResponseDto response = new AuthResponseDto(token, "Bearer", loginRequest.getUsername());

        return ResponseEntity.ok(response);
    }
}
