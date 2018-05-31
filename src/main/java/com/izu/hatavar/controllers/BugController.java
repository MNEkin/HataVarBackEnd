package com.izu.hatavar.controllers;

import com.izu.hatavar.models.Bug;
import com.izu.hatavar.services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BugController
{
    @Autowired
    BugService bugService;

    @GetMapping("/bugs/{userId}")
    public List<Bug> getAll()
    {

        return bugService.findAll();
    }
}
