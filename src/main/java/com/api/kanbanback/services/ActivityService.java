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

    public List<Activity> getActivitiesByTitle(String title) {
        return activityRepository.findByTitleStartsWithIgnoreCase(title);
    }

    public Long getNumberOfLateActivities() {
        return activityRepository.countByStatus("late");
    }

    public Activity save(Long groupId, Activity activity) {
        return groupRepository.findById(groupId).map(group -> {
            int activitiesNum = activityRepository.findByGroupId(groupId).size();
            Integer wip = group.getWorkInProgress();

            if(wip - activitiesNum == 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wip limit is " + wip + "!");
            }

            activity.setGroup(group);
            return activityRepository.save(activity);
        }).get();
    }
    public void update(Long groupId, Activity activity) {
        List<Activity> activities = activityRepository.findByGroupId(groupId);

        Integer activitiesNum = activities.size();

        Group group = groupRepository.findById(groupId).get();
        Integer wip = group.getWorkInProgress();

        if(wip - activitiesNum == 0 && activities.stream()
                .noneMatch((activityExistent) -> activityExistent.getId().equals(activity.getId()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wip limit is " + wip + "!");
        }

        activity.setGroup(group);

        activityRepository.save(activity);
    }
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }
    public void deleteAllActivitiesFromGroup(Long groupId) {
        activityRepository.deleteByGroupId(groupId);
    }
}
