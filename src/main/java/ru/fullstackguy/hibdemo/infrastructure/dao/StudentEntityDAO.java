package ru.fullstackguy.hibdemo.infrastructure.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;

import java.util.Collections;
import java.util.List;

/**
 * Data Access Object (DAO)
 */
@Repository
public class StudentEntityDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public StudentEntity findById(Long id) {
        return entityManager.find(StudentEntity.class, id);
    }

    public StudentEntity create(String studentName, String groupNumber) {
        // todo: добавить реализацию
    }

    public List<StudentEntity> findByGroupName(String groupName) {
        // todo: добавить реализацию
        return Collections.emptyList();
    }
}
