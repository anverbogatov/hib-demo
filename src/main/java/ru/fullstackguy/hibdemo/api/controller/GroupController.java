package ru.fullstackguy.hibdemo.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fullstackguy.hibdemo.api.dto.CreateGroupDto;
import ru.fullstackguy.hibdemo.application.GroupApplicationService;

@RestController
@RequestMapping(path = "/groups")
@RequiredArgsConstructor
public class GroupController {

    @Autowired
    private final GroupApplicationService groupApplicationService;

    @PostMapping
    public void createStudent(@RequestBody CreateGroupDto dto) {
        groupApplicationService.createNewGroup(dto.groupNumber());
    }
}