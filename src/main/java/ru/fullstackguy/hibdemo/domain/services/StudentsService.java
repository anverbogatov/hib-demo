package ru.fullstackguy.hibdemo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;
import ru.fullstackguy.hibdemo.infrastructure.dao.StudentEntityDAO;
import ru.fullstackguy.hibdemo.infrastructure.integrations.RestClient;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentEntityDAO studentEntityDAO;

    @Autowired
    private RestClient restClient;

    @Transactional(readOnly = true)
    public StudentEntity getStudent(Long id) {
        restClient.post(id);
        return studentEntityDAO.findById(id);
    }

    @Transactional
    public void createStudent(String studentName, String groupNumber) {
        studentEntityDAO.create(studentName, groupNumber);
    }

    @Transactional(readOnly = true)
    public List<StudentEntity> getStudentsByGroupName(String groupName) {
        return studentEntityDAO.findByGroupName(groupName);
    }
}
