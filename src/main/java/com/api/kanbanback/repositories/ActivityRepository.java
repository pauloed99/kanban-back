package com.api.kanbanback.repositories;

import com.api.kanbanback.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByGroupId(Long id);
    void deleteByGroupId(Long id);
}
