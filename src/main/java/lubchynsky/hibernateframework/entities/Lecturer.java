package lubchynsky.hibernateframework.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "LECTURER")
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Lecturer {

    @Id
    @Column(name = "LECTURER_ID")
    @Getter
    private int id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "lecturer")
    private List<Course> courses = new ArrayList<>();

    public Lecturer(int id, String name) {
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
