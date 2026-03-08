package com.example.CourseManagement.Service;

import org.springframework.data.domain.Page;

import com.example.CourseManagement.Dto.CourseRequestDto;
import com.example.CourseManagement.Dto.CourseResponseDto;

public interface CourseService {

    CourseResponseDto createCourse(CourseRequestDto request);

    CourseResponseDto updateCourse(Long id, CourseRequestDto request);

    void deleteCourse(Long id);

    CourseResponseDto getCourseById(Long id);

    Page<CourseResponseDto> getAllCourses(int page, int size, String sort);

}
