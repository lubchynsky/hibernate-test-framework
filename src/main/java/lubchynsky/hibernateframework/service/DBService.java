package lubchynsky.hibernateframework.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBService {
    private static final String PERSISTENCE_UNIT = "hibernateframework";

    public void save(Object... objects) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        for (Object obj : objects) {
            em.persist(obj);
        }
        em.getTransaction().commit();
        emf.close();
    }
}
