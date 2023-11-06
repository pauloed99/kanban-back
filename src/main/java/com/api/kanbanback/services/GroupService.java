package com.api.kanbanback.services;

import com.api.kanbanback.models.Group;
import com.api.kanbanback.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group save(Group group) {
        return groupRepository.save(group);
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
