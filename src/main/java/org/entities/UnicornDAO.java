package org.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.jpa.HibernateConfig;

import java.util.List;

public class UnicornDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Unicorn save(Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(unicorn);
        em.getTransaction().commit();
        em.close();
        return unicorn;
    }

    public Unicorn update(Unicorn unicorn) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Unicorn updated = em.merge(unicorn);
        em.getTransaction().commit();
        em.close();
        return updated;
    }

    public Unicorn findById(int id) {
        EntityManager em = emf.createEntityManager();
        Unicorn found = em.find(Unicorn.class, id);
        em.close();
        return found;
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Unicorn unicorn = findById(id);
        if (unicorn != null)
            em.remove(unicorn);
        em.getTransaction().commit();
        em.close();
    }

    public List<Unicorn> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Unicorn> unicornList = em.createQuery("SELECT e FROM Unicorn e")
                .getResultList();
        return unicornList;
    }
}
