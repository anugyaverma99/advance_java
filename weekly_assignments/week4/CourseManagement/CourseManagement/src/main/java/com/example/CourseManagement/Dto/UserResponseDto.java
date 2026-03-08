package com.example.CourseManagement.Dto;

import java.time.LocalDateTime;

import com.example.CourseManagement.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
	private Long id; 
	private String fullName; 
	private String email; 
	private Role role; 
	private String profilePicture; 
	private LocalDateTime createdAt;
	
}
