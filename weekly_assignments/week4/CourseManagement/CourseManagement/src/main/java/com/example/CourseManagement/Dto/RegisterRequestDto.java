package com.example.CourseManagement.Dto;

import com.example.CourseManagement.Entity.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDto {
	@NotBlank(message = "Full name is required") 
	private String fullName;
	@Email(message = "Invalid email") 
	private String email;
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String password;
	private Role role;
	

	

}

