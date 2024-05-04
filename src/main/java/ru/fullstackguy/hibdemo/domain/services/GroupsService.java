package ru.fullstackguy.hibdemo.domain.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fullstackguy.hibdemo.domain.entity.GroupEntity;
import ru.fullstackguy.hibdemo.infrastructure.repositories.GroupRepository;

@Service
@RequiredArgsConstructor
public class GroupsService {

    @Autowired
    private final GroupRepository repository;

    @Transactional
    public void createGroup(String groupNumber) {
        var group = new GroupEntity();
        group.setNumber(groupNumber);

        repository.save(group);
    }
}
