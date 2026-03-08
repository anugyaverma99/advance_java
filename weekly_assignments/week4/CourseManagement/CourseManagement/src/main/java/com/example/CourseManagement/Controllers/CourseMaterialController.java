package com.example.CourseManagement.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.CourseManagement.Dto.MaterialResponseDto;
import com.example.CourseManagement.Service.CourseMaterialService;

import java.util.List;

@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
public class CourseMaterialController {

    private final CourseMaterialService materialService;

    @PostMapping("/upload")
    public MaterialResponseDto uploadMaterial(
            @RequestParam String title,
            @RequestParam Long courseId,
            @RequestParam MultipartFile file) {

        return materialService.uploadMaterial(title, courseId, file);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadMaterial(@PathVariable Long id) {

        Resource file = materialService.downloadMaterial(id);

        return ResponseEntity.ok().body(file);
    }

    @GetMapping("/course/{courseId}")
    public List<MaterialResponseDto> getMaterialsByCourse(@PathVariable Long courseId) {
        return materialService.getMaterialsByCourse(courseId);
    }
}
