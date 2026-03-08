package com.example.CourseManagement.Dto;

import java.time.LocalDateTime;

import com.example.CourseManagement.Entity.EnrollmentStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentResponseDto {
	
	private Long id;
	private String courseTitle;
	private String studentName;
	private EnrollmentStatus status;
	private double progressPercentage;
	private LocalDateTime enrollmentDate;

}
