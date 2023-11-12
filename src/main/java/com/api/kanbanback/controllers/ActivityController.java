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

    @PostMapping("/groups/{id}/activities")
    public ResponseEntity<Activity> save(@PathVariable Long id,@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.save(id, activity));
    }

    @PutMapping("/activities")
    public ResponseEntity<Activity> update(@RequestBody Activity activity) {
        activityService.update(activity);
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
