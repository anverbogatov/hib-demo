package ru.fullstackguy.hibdemo.domain.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.domain.entity.GroupDetailsEntity;
import ru.fullstackguy.hibdemo.domain.entity.GroupEntity;
import ru.fullstackguy.hibdemo.domain.entity.PassportEntity;
import ru.fullstackguy.hibdemo.domain.entity.StudentEntity;
import ru.fullstackguy.hibdemo.domain.entity.SubjectEntity;
import ru.fullstackguy.hibdemo.infrastructure.repositories.GroupRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupsService {

    @Autowired
    private final GroupRepository repository;

    @Transactional
    public void createGroup(String groupNumber,
                            String telegramChannel,
                            List<StudentDto> students) {
        var groupStudents = students.stream()
                .map(el -> {
                    var passport = new PassportEntity();
                    passport.setSeries(el.passport().series());
                    passport.setNumber(el.passport().number());

                    var subjects = el.subjects().stream()
                            .map(subj -> {
                                var subject = new SubjectEntity();
                                subject.setName(subj);
                                return subject;
                            })
                            .toList();

                    var student = new StudentEntity();
                    student.setName(el.name());
                    student.setPassport(passport);
                    student.setSubjects(subjects);
                    return student;
                })
                .toList();

        var details = new GroupDetailsEntity();
        details.setTelegramChannel(telegramChannel);

        var group = new GroupEntity();
        group.setNumber(groupNumber);
        group.setDetails(details);
        group.setStudents(groupStudents);

        repository.save(group);
    }

    public StudentDto getStudent() {
        return null;
    }
}
