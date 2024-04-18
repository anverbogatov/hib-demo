package ru.fullstackguy.hibdemo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fullstackguy.hibdemo.api.dto.CreateStudentDto;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.application.StudentApplicationService;

import java.util.List;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentApplicationService studentApplicationService;

    @GetMapping("/{id}")
    public StudentDto getStudentNameById(@PathVariable("id") Long id) {
        return studentApplicationService.getStudentName(id);
    }

    @GetMapping
    public List<StudentDto> getStudentsByGroup(@RequestParam("groupName") String groupName) {
        return studentApplicationService.getStudentsByGroup(groupName);
    }


    @PostMapping
    public void createStudent(@RequestBody CreateStudentDto dto) {
        studentApplicationService.createStudent(dto);
    }
}
