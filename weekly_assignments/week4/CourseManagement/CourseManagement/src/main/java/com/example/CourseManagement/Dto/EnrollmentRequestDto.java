package com.example.CourseManagement.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequestDto {
	
	private Long courseId;
	private Long studentId;
	

}

