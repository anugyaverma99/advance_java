package com.example.CourseManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseManagement.Entity.Course;

public interface CourseRepository extends JpaRepository<Course,Long>{
	List<Course> findByInstructorId(Long instructorId);

}
