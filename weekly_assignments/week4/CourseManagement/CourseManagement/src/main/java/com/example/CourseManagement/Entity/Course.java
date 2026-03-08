package com.example.CourseManagement.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private double price;
	private String duration;
	private String level;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	 @OneToMany(mappedBy = "course")
	    private List<Enrollment> enrollments;

	 @OneToMany(mappedBy = "course")
	    private List<CourseMaterial> materials; @ManyToOne
	  @JoinColumn(name = "instructor_id")
	  private User instructor;
	
	

	public Course() {
		// TODO Auto-generated constructor stub
	}

}
