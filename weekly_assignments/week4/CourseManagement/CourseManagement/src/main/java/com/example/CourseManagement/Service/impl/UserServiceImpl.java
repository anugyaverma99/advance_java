package com.example.CourseManagement.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.CourseManagement.Dto.LoginRequestDto;
import com.example.CourseManagement.Dto.RegisterRequestDto;
import com.example.CourseManagement.Dto.UserResponseDto;
import com.example.CourseManagement.Entity.User;
import com.example.CourseManagement.Mapper.UserMapper;
import com.example.CourseManagement.Repository.UserRepository;
import com.example.CourseManagement.Service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(RegisterRequestDto request) {

        User user = UserMapper.toEntity(request);

        User savedUser = userRepository.save(user);

        return UserMapper.toDTO(savedUser);
    }

    @Override
    public String loginUser(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Login successful";
    }

    @Override
    public UserResponseDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserMapper.toDTO(user);
    }
}
