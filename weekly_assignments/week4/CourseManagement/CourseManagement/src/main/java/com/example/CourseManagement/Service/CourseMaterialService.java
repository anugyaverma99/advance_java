package com.example.CourseManagement.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.CourseManagement.Dto.MaterialResponseDto;
import org.springframework.core.io.Resource;


public interface CourseMaterialService {
	 MaterialResponseDto uploadMaterial(String title, Long courseId, MultipartFile file);

	    Resource downloadMaterial(Long materialId);

	    List<MaterialResponseDto> getMaterialsByCourse(Long courseId);
}
