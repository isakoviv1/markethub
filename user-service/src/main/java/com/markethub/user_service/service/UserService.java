package com.markethub.user_service.service;

import com.markethub.user_service.domain.entity.User;
import com.markethub.user_service.domain.enums.Role;
import com.markethub.user_service.dto.request.LoginRequest;
import com.markethub.user_service.dto.request.RegisterRequest;
import com.markethub.user_service.dto.response.AuthResponse;
import com.markethub.user_service.dto.response.UserProfileResponse;
import com.markethub.user_service.repository.UserRepository;
import com.markethub.user_service.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthResponse register(RegisterRequest registerRequest){
        if(userRepository.findByEmail(registerRequest.getEmail()).isPresent())
            throw new RuntimeException("User already exists");

        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());

        User newUser = User.builder()
                        .firstname(registerRequest.getFirstname())
                        .lastname(registerRequest.getLastname())
                        .email(registerRequest.getEmail())
                        .password(hashedPassword)
                        .role(Role.USER)
                        .build();

        userRepository.save(newUser);

        return AuthResponse.builder()
                .accessToken(jwtService.generateToken(newUser))
                .tokenType("Bearer")
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
            throw new RuntimeException("Password is wrong");

        return AuthResponse.builder()
                .accessToken(jwtService.generateToken(user))
                .tokenType("Bearer")
                .build();
    }

    public UserProfileResponse getProfile(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserProfileResponse.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }
}
