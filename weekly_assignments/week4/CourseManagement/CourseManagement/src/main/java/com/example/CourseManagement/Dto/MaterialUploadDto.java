package com.example.CourseManagement.Dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialUploadDto {
	private String title;
	private Long courseId;
	private MultipartFile file;
	

	
}
