package com.api.kanbanback.repositories;

import com.api.kanbanback.models.Activity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByGroupId(Long id);
    List<Activity> findByTitleStartsWithIgnoreCase(String title);
    Long countByStatus(String status);
    @Transactional
    void deleteByGroupId(Long id);
}
