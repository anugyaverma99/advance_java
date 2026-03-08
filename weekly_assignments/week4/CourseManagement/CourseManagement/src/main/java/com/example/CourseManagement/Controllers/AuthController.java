package com.example.CourseManagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.CourseManagement.Dto.LoginRequestDto;
import com.example.CourseManagement.Dto.RegisterRequestDto;
import com.example.CourseManagement.Dto.UserResponseDto;
import com.example.CourseManagement.Service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    // Register new user
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody RegisterRequestDto request) {
        return userService.registerUser(request);
    }

    // Login user
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto request) {
        return userService.loginUser(request);
    }
}
