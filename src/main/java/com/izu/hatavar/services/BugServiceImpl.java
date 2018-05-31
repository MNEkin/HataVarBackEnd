package com.izu.hatavar.services;

import com.izu.hatavar.models.Bug;
import com.izu.hatavar.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugServiceImpl implements BugService
{
    @Autowired
    private BugRepository bugRepository;

    @Override
    public List<Bug> findAll()
    {
        return bugRepository.findAll();
    }
}
