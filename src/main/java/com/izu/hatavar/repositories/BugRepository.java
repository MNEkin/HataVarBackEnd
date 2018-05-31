package com.izu.hatavar.repositories;

import com.izu.hatavar.models.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long>
{
    @Override
    List<Bug> findAll();
}
