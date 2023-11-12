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
    private GroupRepository groupRepository;

    public List<Activity> getAllActivitiesByGroup(Long id) {
        return activityRepository.findByGroupId(id);
    }
    public Activity save(Long groupId, Activity activityRequest) {
        Activity activity = groupRepository.findById(groupId).map(group -> {
            activityRequest.setGroup(group);
            return activityRepository.save(activityRequest);
        }).get();

        return activity;
    }
    public void update(Activity activity) {
        activityRepository.save(activity);
    }
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
    public void deleteAllActivitiesFromGroup(Long groupId) {
        activityRepository.deleteByGroupId(groupId);
    }
}
