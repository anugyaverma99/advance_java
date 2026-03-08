package com.example.CourseManagement.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
@Builder
public class CourseMaterial {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String fileName;
	private String fileType;
	private String fileUrl;
	private LocalDateTime uploadDate;
	@ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


	public CourseMaterial() {
		// TODO Auto-generated constructor stub
	}

}
