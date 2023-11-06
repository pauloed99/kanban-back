package com.api.kanbanback.controllers;

import com.api.kanbanback.models.Activity;
import com.api.kanbanback.services.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("activities")
public class ActivityController {
    private ActivityService activityService;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activityService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
