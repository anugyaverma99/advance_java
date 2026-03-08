package com.example.CourseManagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.CourseManagement.Dto.CourseRequestDto;
import com.example.CourseManagement.Dto.CourseResponseDto;
import com.example.CourseManagement.Service.CourseService;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto request) {
        return courseService.createCourse(request);
    }

    @GetMapping("/{id}")
    public CourseResponseDto getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    // Update course
    @PutMapping("/{id}")
    public CourseResponseDto updateCourse(
            @PathVariable Long id,
            @RequestBody CourseRequestDto request) {

        return courseService.updateCourse(id, request);
    }

    // Delete course
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    // Get all courses with pagination
    @GetMapping
    public Page<CourseResponseDto> getAllCourses(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort) {

        return courseService.getAllCourses(page, size, sort);
    }
}
