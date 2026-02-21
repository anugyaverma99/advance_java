package entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    private int courseId;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student_class> students = new ArrayList<>();

    public Course() {
    }

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student_class> getStudents() {
        return students;
    }

    public void setStudents(List<Student_class> students) {
        this.students = students;
    }
}