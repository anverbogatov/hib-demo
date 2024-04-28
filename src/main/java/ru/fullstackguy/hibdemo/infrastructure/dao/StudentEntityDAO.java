package ru.fullstackguy.hibdemo.infrastructure.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.fullstackguy.hibdemo.domain.entity.GroupEntity;
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
        var group = new GroupEntity();
        group.setNumber(groupNumber);

        entityManager.persist(group);

        var studentEntity = new StudentEntity();
        studentEntity.setName(studentName);
//        studentEntity.setGroup(group);
        entityManager.persist(studentEntity);

        return studentEntity;
    }

    public List<StudentEntity> findByGroupName(String groupName) {
        // todo: добавить реализацию
        return Collections.emptyList();
    }
}
