package com.lesi.rpg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lesi.rpg.entity.User;
import com.lesi.rpg.repository.UserRepository;
import com.lesi.rpg.util.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User registerUser(User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new RuntimeException("El nombre de usuario ya existe, toma otro.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String login(String username, String rawPassword){
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if(!passwordEncoder.matches(rawPassword, user.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
