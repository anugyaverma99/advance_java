package com.example.CourseManagement.Mapper;


import java.time.LocalDateTime;

import com.example.CourseManagement.Dto.RegisterRequestDto;
import com.example.CourseManagement.Dto.UserResponseDto;
import com.example.CourseManagement.Entity.User;

public class UserMapper {

    public static User toEntity(RegisterRequestDto dto) {

        return User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static UserResponseDto toDTO(User user) {

        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        dto.setProfilePicture(user.getProfilePicture());
        dto.setCreatedAt(user.getCreatedAt());

        return dto;
    }
}