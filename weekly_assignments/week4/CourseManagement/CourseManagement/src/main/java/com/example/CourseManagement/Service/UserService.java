package com.example.CourseManagement.Service;

import com.example.CourseManagement.Dto.LoginRequestDto;
import com.example.CourseManagement.Dto.RegisterRequestDto;
import com.example.CourseManagement.Dto.UserResponseDto;

public interface UserService {

    UserResponseDto registerUser(RegisterRequestDto request);

    String loginUser(LoginRequestDto request);

    UserResponseDto getUserById(Long id);

}