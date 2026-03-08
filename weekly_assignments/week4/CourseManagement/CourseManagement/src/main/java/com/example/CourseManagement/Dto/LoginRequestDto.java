package com.example.CourseManagement.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
	@Email(message = "Invalid email") 
	private String email; 
	@NotBlank(message = "Password is required") 
	private String password;
	


}
