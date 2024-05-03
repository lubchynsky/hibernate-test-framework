package lubchynsky.hibernateframework.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @Getter
    private int id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
