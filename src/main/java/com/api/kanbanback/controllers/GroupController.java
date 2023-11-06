package com.api.kanbanback.controllers;

import com.api.kanbanback.models.Group;
import com.api.kanbanback.services.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("groups")
public class GroupController {
    private GroupService groupService;
    @GetMapping
    public ResponseEntity<List<Group>> findAll() {
        return ResponseEntity.ok(groupService.findAll());
    }
    @PostMapping
    public ResponseEntity<Group> save(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.save(group));
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Group group) {
        groupService.save(group);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
