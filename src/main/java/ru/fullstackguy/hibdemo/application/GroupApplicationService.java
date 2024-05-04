package ru.fullstackguy.hibdemo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fullstackguy.hibdemo.domain.services.GroupsService;

@Component
@RequiredArgsConstructor
public class GroupApplicationService {

    @Autowired
    private final GroupsService groupsService;

    public void createNewGroup(String groupNumber, String telegramChannel) {
        groupsService.createGroup(groupNumber, telegramChannel);
    }
}
