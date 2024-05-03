package lubchynsky.hibernateframework.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "COURSES")
@NoArgsConstructor
public class Course {

    @Id
    @Column(name = "COURSE_ID")
    @Getter
    private int id;

    @Column(name = "COURSE_NAME")
    @Getter
    @Setter
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "LECTURER_ID")
    @Getter
    @Setter
    private Lecturer lecturer;

    @ManyToMany
    @JoinColumn(name = "STUDENT_ID")
    List<Student> students = new ArrayList<>();

    public Course(int id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
