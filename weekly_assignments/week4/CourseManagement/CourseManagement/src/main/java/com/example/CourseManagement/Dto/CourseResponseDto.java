package com.example.CourseManagement.Dto;
import lombok.Data; 
import java.time.LocalDateTime; 
@Data
public class CourseResponseDto {
	private Long id; 
	private String title; 
	private String description; 
	private double price; 
	private String duration; 
	private String level; 
	private String instructorName; 
	private LocalDateTime createdAt;
	public CourseResponseDto() {
		// TODO Auto-generated constructor stub
	}

}
