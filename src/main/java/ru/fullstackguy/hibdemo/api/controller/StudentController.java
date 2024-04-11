package ru.fullstackguy.hibdemo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.application.StudentApplicationService;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentApplicationService studentApplicationService;

    @GetMapping("/{id}")
    public StudentDto getStudentNameById(@PathVariable("id") Long id) {
        return studentApplicationService.getStudentName(id);
    }

    public void createStudent(StudentEntity entity) {

    }
}
