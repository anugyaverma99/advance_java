package com.example.CourseManagement.Mapper;

import com.example.CourseManagement.Dto.MaterialResponseDto;
import com.example.CourseManagement.Entity.CourseMaterial;

public class CourseMaterialMapper {

    public static MaterialResponseDto toDTO(CourseMaterial material) {

        MaterialResponseDto dto = new MaterialResponseDto();

        dto.setId(material.getId());
        dto.setTitle(material.getTitle());
        dto.setFileName(material.getFileName());
        dto.setFileType(material.getFileType());
        dto.setFileUrl(material.getFileUrl());
        dto.setUploadDate(material.getUploadDate());

        return dto;
    }
}
