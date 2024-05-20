package ru.fullstackguy.hibdemo.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fullstackguy.hibdemo.api.dto.StudentDto;
import ru.fullstackguy.hibdemo.domain.services.GroupsService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupApplicationServiceTest {


    private GroupApplicationService service;

    private GroupsService groupsService;

    @BeforeEach
    void setUp() {
        groupsService = Mockito.mock(GroupsService.class);
        service = new GroupApplicationService(groupsService);
    }

    @Test
    void createNewGroup() {
        // given
        var groupNumber = "403a";
        var telegramChannel = "403a-the-best";
        var students = List.of(new StudentDto("Anver", null, null));

        // when
        service.createNewGroup(groupNumber, telegramChannel, students);

        // then
        var captor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(groupsService, Mockito.times(1)).createGroup(Mockito.anyString(), captor.capture(), Mockito.anyList());

        var telegramValue = captor.getValue();
        Assertions.assertEquals("403a-the-best1111111", telegramValue);
    }

    @Test
    void findStudent() {
        // given
        var studentDto = new StudentDto("Denis", null, null);
        Mockito.when(groupsService.getStudent()).thenReturn(studentDto);

        Mockito.when(groupsService.getStudent()).thenThrow(new RuntimeException("lskjdfkljhsdkjfh"));

        // when
        var result = service.findStudent();

        // then
        Assertions.assertEquals(studentDto, result);
    }
}