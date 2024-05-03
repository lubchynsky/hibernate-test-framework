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

        Lecturer lecturer = new Lecturer(1, "Henry");
        Course course = new Course(1, "Math");
        course.setLecturer(lecturer);
        Student student = new Student(1, "John");
        course.addStudent(student);
        em.persist(lecturer);
        em.persist(course);
        em.persist(student);

        em.getTransaction().commit();
        emf.close();
    }
}
