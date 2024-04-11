package ru.fullstackguy.hibdemo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;
import ru.fullstackguy.hibdemo.infrastructure.dao.StudentEntityDAO;

@Service
public class StudentsService {

    @Autowired
    private StudentEntityDAO studentEntityDAO;

    @Transactional(readOnly = true)
    public StudentEntity getStudent(Long id) {
        return studentEntityDAO.findById2(id);
    }

    @Transactional
    public StudentEntity createStudent(String name) {
        var studentEntity = new StudentEntity();
        studentEntity.setName(name);
        studentEntityDAO.createStudent(studentEntity);
        return null;
    }
}
