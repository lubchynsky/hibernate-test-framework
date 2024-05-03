package lubchynsky.hibernateframework;

import lubchynsky.hibernateframework.entities.Course;
import lubchynsky.hibernateframework.entities.Lecturer;
import lubchynsky.hibernateframework.entities.Student;
import lubchynsky.hibernateframework.service.DBService;
import org.junit.jupiter.api.Test;

public class AddEntitiesTest {

    @Test
    public void saveEntities() {
        DBService dbService = new DBService();


        Lecturer lecturer = new Lecturer("Henry");
        Course course = new Course("Math");
        course.setLecturer(lecturer);
        Student student = new Student("Johny");
        student.setCity("Berlin");
        student.setCountry("Germany");
        student.setEmail("test@test.com");
        student.setPhone("123-345-567");
        course.addStudent(student);

        dbService.save(lecturer, course, student);
    }
}
