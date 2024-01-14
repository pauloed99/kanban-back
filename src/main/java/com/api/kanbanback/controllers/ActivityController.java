package com.api.kanbanback.controllers;

import com.api.kanbanback.models.Activity;
import com.api.kanbanback.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping
public class ActivityController {
    private ActivityService activityService;
    @GetMapping("/groups/{id}/activities")
    public ResponseEntity<List<Activity>> getAllByGroup(@PathVariable Long id) {
        return ResponseEntity.ok(activityService.getAllActivitiesByGroup(id));
    }
    @GetMapping("/activities/filter")
    public ResponseEntity<List<Activity>> getByTitle(@RequestParam String title) {
        return ResponseEntity.ok(activityService.getActivitiesByTitle(title));
    }
    @GetMapping("/activities/late")
    public ResponseEntity<Long> getNumberOfLateActivities() {
        return ResponseEntity.ok(activityService.getNumberOfLateActivities());
    }
    @PostMapping("/groups/{id}/activities")
    public ResponseEntity<Activity> save(@PathVariable Long id, @RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.save(id, activity));
    }

    @PutMapping("/groups/{id}/activities")
    public ResponseEntity<Activity> update(@PathVariable Long id, @RequestBody Activity activity) {
        activityService.update(id, activity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/activities/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/groups/{id}/activities")
    public ResponseEntity<Void> deleteAll(@PathVariable Long id) {
        activityService.deleteAllActivitiesFromGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
