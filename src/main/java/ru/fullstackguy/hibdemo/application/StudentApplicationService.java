package ru.fullstackguy.hibdemo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.domain.services.StudentsService;

@Component
public class StudentApplicationService {

    @Autowired
    private StudentsService studentsService;

    public StudentDto getStudentName(long id) {
        var student = studentsService.getStudent(id);
        return new StudentDto(student.getName());
    }
}
