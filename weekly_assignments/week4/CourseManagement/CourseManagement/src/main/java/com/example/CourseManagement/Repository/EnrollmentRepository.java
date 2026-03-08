package com.example.CourseManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseManagement.Entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Long>{
	List<Enrollment> findByStudentId(Long studentId);

    List<Enrollment> findByCourseId(Long courseId);
}
