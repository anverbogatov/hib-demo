package ru.fullstackguy.hibdemo.domain.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fullstackguy.hibdemo.domain.entity.GroupDetailsEntity;
import ru.fullstackguy.hibdemo.domain.entity.GroupEntity;
import ru.fullstackguy.hibdemo.infrastructure.repositories.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupsService {

    @Autowired
    private final GroupRepository repository;

    @Transactional
    public void createGroup(String groupNumber,
                            String telegramChannel) {
        var details = new GroupDetailsEntity();
        details.setTelegramChannel(telegramChannel);

        var group = new GroupEntity();
        group.setNumber(groupNumber);
        group.setDetails(details);

        repository.save(group);
    }
}
