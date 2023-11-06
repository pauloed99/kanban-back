package com.api.kanbanback.services;

import com.api.kanbanback.models.Activity;
import com.api.kanbanback.models.Group;
import com.api.kanbanback.repositories.ActivityRepository;
import com.api.kanbanback.repositories.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivityService {
    private ActivityRepository activityRepository;
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
}
