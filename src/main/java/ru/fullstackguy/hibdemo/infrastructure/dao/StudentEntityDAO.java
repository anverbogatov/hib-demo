package ru.fullstackguy.hibdemo.infrastructure.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;

/**
 * Data Access Object (DAO)
 */
@Repository
public class StudentEntityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void createStudent(StudentEntity entity) {
        entityManager.persist(entity);
    }

    public StudentEntity findById2(Long id) {
        return entityManager.find(StudentEntity.class, id);
    }

    @Transactional(readOnly = true)
    public String findById(Long id) {
        var student = entityManager.find(StudentEntity.class, id);

        var query = entityManager.createQuery("from StudentEntity se where se.name = ?", StudentEntity.class);
        query.setParameter(0, student.getName());
        var student2 = query.getSingleResult();

        var query2 = entityManager.createNativeQuery("select * from students s where s.name = ?", StudentEntity.class);
        query2.setParameter(1, student.getName());


        return student.getName();
    }
}
