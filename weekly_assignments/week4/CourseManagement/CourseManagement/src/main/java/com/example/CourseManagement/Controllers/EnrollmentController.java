package com.example.CourseManagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.CourseManagement.Dto.EnrollmentRequestDto;
import com.example.CourseManagement.Dto.EnrollmentResponseDto;
import com.example.CourseManagement.Service.EnrollmentService;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    // Enroll student in course
    @PostMapping
    public EnrollmentResponseDto enrollStudent(@RequestBody EnrollmentRequestDto request) {
        return enrollmentService.enrollStudent(request);
    }

    // Get enrollments by student
    @GetMapping("/student/{studentId}")
    public List<EnrollmentResponseDto> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.getEnrollmentsByStudent(studentId);
    }

    // Get enrollments by course
    @GetMapping("/course/{courseId}")
    public List<EnrollmentResponseDto> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }

    // Update progress
    @PutMapping("/{id}/progress")
    public EnrollmentResponseDto updateProgress(
            @PathVariable Long id,
            @RequestParam double progress) {

        return enrollmentService.updateProgress(id, progress);
    }
}