package com.example.CourseManagement.Mapper;


import java.time.LocalDateTime;

import com.example.CourseManagement.Dto.CourseRequestDto;
import com.example.CourseManagement.Dto.CourseResponseDto;
import com.example.CourseManagement.Entity.Course;
import com.example.CourseManagement.Entity.User;

public class CourseMapper {

    public static Course toEntity(CourseRequestDto dto, User instructor) {

        return Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .duration(dto.getDuration())
                .level(dto.getLevel())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .instructor(instructor)
                .build();
    }

    public static CourseResponseDto toDTO(Course course) {

        CourseResponseDto dto = new CourseResponseDto();

        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setPrice(course.getPrice());
        dto.setDuration(course.getDuration());
        dto.setLevel(course.getLevel());
        dto.setInstructorName(course.getInstructor().getFullName());
        dto.setCreatedAt(course.getCreatedAt());

        return dto;
    }
}