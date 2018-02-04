package id.or.greenlabs.demo.jpa.dao.impl;

import id.or.greenlabs.demo.jpa.dao.StudentDAO;
import id.or.greenlabs.demo.jpa.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;

/**
 * @Author krissadewo
 * @Date 16/01/18
 **/
public class StudentDAOImpl implements StudentDAO {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");

    public Student save(Student entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();

        return entity;
    }

    public Student update(Student entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Student result = em.find(Student.class, entity.getId());
        result.setName(entity.getName());
        em.flush();

        em.getTransaction().commit();
        em.close();

        return entity;
    }

    public Student delete(Student entity) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
        em.close();

        return entity;
    }

    public Student findById(Long id) {
        return entityManagerFactory.createEntityManager().find(Student.class, id);
    }

    public Collection<Student> find(Student param, int offset, int limit) {
        EntityManager em = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);

        Root<Student> root = query.from(Student.class);

        query.orderBy(criteriaBuilder.asc(root.get("id")));

        // Execute query with pagination
        return em.createQuery(query)
                .setMaxResults(limit)
                .setFirstResult(offset)
                .getResultList();
    }

    public Long count(Student param) {
        return null;
    }
}
