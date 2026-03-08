package com.example.CourseManagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.CourseManagement.Dto.UserResponseDto;
import com.example.CourseManagement.Service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Get user by ID
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}