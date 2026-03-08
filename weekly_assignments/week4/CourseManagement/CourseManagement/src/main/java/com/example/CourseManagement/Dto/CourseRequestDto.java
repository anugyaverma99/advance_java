package com.example.CourseManagement.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive; 
import lombok.Data; @Data
public class CourseRequestDto {
	@NotBlank(message = "Course title is required")
	private String title; 
	@NotBlank(message = "Description is required")
	private String description;
	@Positive(message = "Price must be positive")
	private double price; 
	private String duration;
	private String level;
	private Long instructorId;
	public CourseRequestDto() {
		// TODO Auto-generated constructor stub
	}

}
