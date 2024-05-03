package lubchynsky.hibernateframework.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lubchynsky.hibernateframework.entities.Course;
import lubchynsky.hibernateframework.entities.Lecturer;
import lubchynsky.hibernateframework.entities.Student;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateframework");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Lecturer lecturer = new Lecturer("Henry");
        Course course = new Course("Math");
        course.setLecturer(lecturer);
        Student student = new Student("Johny");
        student.setCity("Berlin");
        student.setCountry("Germany");
        student.setEmail("test@test.com");
        //student.setPhone("123-345-567");
        course.addStudent(student);
        em.persist(lecturer);
        em.persist(course);
        em.persist(student);

        em.getTransaction().commit();
        emf.close();
    }
}
