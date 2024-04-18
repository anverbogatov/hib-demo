package ru.fullstackguy.hibdemo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fullstackguy.hibdemo.api.dto.CreateStudentDto;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.domain.services.StudentsService;

import java.util.List;

@Component
public class StudentApplicationService {

    @Autowired
    private StudentsService studentsService;

    public StudentDto getStudentName(long id) {
        var student = studentsService.getStudent(id);
        return new StudentDto(student.getId(), student.getName(),
                student.getGroup().getId(), student.getGroup().getNumber());
    }

    public void createStudent(CreateStudentDto createStudentDto) {
        studentsService.createStudent(createStudentDto.studentName(), createStudentDto.groupName());
    }

    public List<StudentDto> getStudentsByGroup(String groupName) {
        var entities = studentsService.getStudentsByGroupName(groupName);
        return entities.stream()
                .map(el -> new StudentDto(el.getId(), el.getName(),
                        el.getGroup().getId(), el.getGroup().getNumber()))
                .toList();
    }
}
