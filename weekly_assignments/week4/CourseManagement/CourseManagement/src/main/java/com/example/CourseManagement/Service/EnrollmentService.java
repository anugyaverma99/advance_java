package com.example.CourseManagement.Service;

import java.util.List;

import com.example.CourseManagement.Dto.EnrollmentRequestDto;
import com.example.CourseManagement.Dto.EnrollmentResponseDto;

public interface EnrollmentService {
	 EnrollmentResponseDto enrollStudent(EnrollmentRequestDto request);

	    List<EnrollmentResponseDto> getEnrollmentsByStudent(Long studentId);

	    List<EnrollmentResponseDto> getEnrollmentsByCourse(Long courseId);

	    EnrollmentResponseDto updateProgress(Long enrollmentId, double progress);

}
