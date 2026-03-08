package com.example.CourseManagement.Service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.CourseManagement.Dto.EnrollmentRequestDto;
import com.example.CourseManagement.Dto.EnrollmentResponseDto;
import com.example.CourseManagement.Entity.Course;
import com.example.CourseManagement.Entity.Enrollment;
import com.example.CourseManagement.Entity.EnrollmentStatus;
import com.example.CourseManagement.Entity.User;
import com.example.CourseManagement.Mapper.EnrollmentMapper;
import com.example.CourseManagement.Repository.CourseRepository;
import com.example.CourseManagement.Repository.EnrollmentRepository;
import com.example.CourseManagement.Repository.UserRepository;
import com.example.CourseManagement.Service.EnrollmentService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public EnrollmentResponseDto enrollStudent(EnrollmentRequestDto request) {

        User student = userRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .status(EnrollmentStatus.ACTIVE)
                .progressPercentage(0)
                .enrollmentDate(LocalDateTime.now())
                .build();

        Enrollment saved = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.toDTO(saved);
    }

    @Override
    public List<EnrollmentResponseDto> getEnrollmentsByStudent(Long studentId) {

        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(EnrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EnrollmentResponseDto> getEnrollmentsByCourse(Long courseId) {

        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(EnrollmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentResponseDto updateProgress(Long enrollmentId, double progress) {

        Enrollment enrollment = enrollmentRepository.findById(enrollmentId)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));

        enrollment.setProgressPercentage(progress);

        if (progress >= 100) {
            enrollment.setStatus(EnrollmentStatus.COMPLETED);
        }

        Enrollment updated = enrollmentRepository.save(enrollment);

        return EnrollmentMapper.toDTO(updated);
    }
}
