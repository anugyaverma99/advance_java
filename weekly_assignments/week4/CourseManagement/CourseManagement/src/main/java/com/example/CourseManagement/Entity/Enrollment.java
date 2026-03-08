package com.example.CourseManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime enrollmentDate;

    @Enumerated(EnumType.STRING)
    private EnrollmentStatus status;

    private double progressPercentage;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}