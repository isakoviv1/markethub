package com.markethub.user_service.controller;

import com.markethub.user_service.dto.request.LoginRequest;
import com.markethub.user_service.dto.request.RegisterRequest;
import com.markethub.user_service.dto.response.AuthResponse;
import com.markethub.user_service.dto.response.UserProfileResponse;
import com.markethub.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthResponse register(@RequestBody RegisterRequest registerRequest){
            return userService.register(registerRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
            return userService.login(loginRequest);
    }

    @GetMapping("/me")
    public UserProfileResponse getProfile(){
            return null;
    }
}
