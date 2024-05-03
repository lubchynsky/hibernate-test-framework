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
@SecondaryTables( value = {
        @SecondaryTable( name = "CONTACTS",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID")),
        @SecondaryTable( name = "ADDRESSES",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "STUDENT_ID", referencedColumnName = "STUDENT_ID"))}
)
@Access(AccessType.FIELD)
@NoArgsConstructor
public class Student {

    @Id
    @Column(name = "STUDENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private int id;

    @Column(name = "NAME")
    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    @Column(name = "CITY", table = "ADDRESSES", columnDefinition = "varchar(25)")
    @Getter
    @Setter
    private String city;

    @Column(name = "COUNTRY", table = "ADDRESSES", columnDefinition = "varchar(25)")
    @Getter
    @Setter
    private String country;

    @Column(name = "EMAIL", table = "CONTACTS", columnDefinition = "varchar(25)")
    @Getter
    @Setter
    private String email;

    @Column(name = "PHONE", table = "CONTACTS", columnDefinition = "varchar(25)")
    @Getter
    @Setter
    private String phone;

    public Student(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}
