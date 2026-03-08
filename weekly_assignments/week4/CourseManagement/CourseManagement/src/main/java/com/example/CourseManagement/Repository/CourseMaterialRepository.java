package com.example.CourseManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseManagement.Entity.CourseMaterial;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long>{
	List<CourseMaterial> findByCourseId(Long courseId);
}
