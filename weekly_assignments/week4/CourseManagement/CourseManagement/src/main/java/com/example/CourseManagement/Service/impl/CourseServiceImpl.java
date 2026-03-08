package com.example.CourseManagement.Service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.example.CourseManagement.Dto.CourseRequestDto;
import com.example.CourseManagement.Dto.CourseResponseDto;
import com.example.CourseManagement.Entity.Course;
import com.example.CourseManagement.Entity.User;
import com.example.CourseManagement.Mapper.CourseMapper;
import com.example.CourseManagement.Repository.CourseRepository;
import com.example.CourseManagement.Repository.UserRepository;
import com.example.CourseManagement.Service.CourseService;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Override
    public CourseResponseDto createCourse(CourseRequestDto request) {
        User instructor = userRepository.findById(request.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = CourseMapper.toEntity(request, instructor);
        Course savedCourse = courseRepository.save(course);

        return CourseMapper.toDTO(savedCourse);
    }

    @Override
    public CourseResponseDto updateCourse(Long id, CourseRequestDto request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setDuration(request.getDuration());
        course.setLevel(request.getLevel());

        Course updated = courseRepository.save(course);
        return CourseMapper.toDTO(updated);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseRepository.delete(course);
    }

    @Override
    public CourseResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return CourseMapper.toDTO(course);
    }

    @Override
    public Page<CourseResponseDto> getAllCourses(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        Page<Course> courses = courseRepository.findAll(pageable);
        return courses.map(CourseMapper::toDTO);
    }
}
