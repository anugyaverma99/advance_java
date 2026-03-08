package com.example.CourseManagement.Service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.CourseManagement.Dto.MaterialResponseDto;
import com.example.CourseManagement.Entity.Course;
import com.example.CourseManagement.Entity.CourseMaterial;
import com.example.CourseManagement.Mapper.CourseMaterialMapper;
import com.example.CourseManagement.Repository.CourseMaterialRepository;
import com.example.CourseManagement.Repository.CourseRepository;
import com.example.CourseManagement.Service.CourseMaterialService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseMaterialServiceImpl implements CourseMaterialService {

    private final CourseMaterialRepository materialRepository;
    private final CourseRepository courseRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public MaterialResponseDto uploadMaterial(String title, Long courseId, MultipartFile file) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        String fileName = file.getOriginalFilename();

        try {

            Path path = Paths.get(uploadDir);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Path filePath = path.resolve(fileName);

            Files.copy(file.getInputStream(), filePath);

            CourseMaterial material = CourseMaterial.builder()
                    .title(title)
                    .fileName(fileName)
                    .fileType(file.getContentType())
                    .fileUrl(filePath.toString())
                    .uploadDate(LocalDateTime.now())
                    .course(course)
                    .build();

            CourseMaterial saved = materialRepository.save(material);

            return CourseMaterialMapper.toDTO(saved);

        } catch (IOException e) {
            throw new RuntimeException("File upload failed");
        }
    }

    @Override
    public Resource downloadMaterial(Long materialId) {

        CourseMaterial material = materialRepository.findById(materialId)
                .orElseThrow(() -> new RuntimeException("Material not found"));

        try {

            Path path = Paths.get(material.getFileUrl());

            return new UrlResource(path.toUri());

        } catch (MalformedURLException e) {

            throw new RuntimeException("File not found");
        }
    }

    @Override
    public List<MaterialResponseDto> getMaterialsByCourse(Long courseId) {

        return materialRepository.findByCourseId(courseId)
                .stream()
                .map(CourseMaterialMapper::toDTO)
                .collect(Collectors.toList());
    }
}
