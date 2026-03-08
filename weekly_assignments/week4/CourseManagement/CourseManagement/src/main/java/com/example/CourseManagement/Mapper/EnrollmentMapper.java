package com.example.CourseManagement.Mapper;

import com.example.CourseManagement.Dto.EnrollmentResponseDto;
import com.example.CourseManagement.Entity.Enrollment;

public class EnrollmentMapper {

    public static EnrollmentResponseDto toDTO(Enrollment enrollment) {

        EnrollmentResponseDto dto = new EnrollmentResponseDto();

        dto.setId(enrollment.getId());
        dto.setCourseTitle(enrollment.getCourse().getTitle());
        dto.setStudentName(enrollment.getStudent().getFullName());
        dto.setStatus(enrollment.getStatus());
        dto.setProgressPercentage(enrollment.getProgressPercentage());
        dto.setEnrollmentDate(enrollment.getEnrollmentDate());

        return dto;
    }
}
