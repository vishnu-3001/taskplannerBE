package com.taskplanner.taskplanner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taskplanner.taskplanner.service.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import com.taskplanner.taskplanner.dto.*;
import java.util.*;


@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from this origin
public class TaskController {
    private TaskService tService;
    public TaskController(TaskService service){
        this.tService=service;
    }
    @GetMapping
    public List<TaskDto> getAllTasklets() {
        return tService.getAllTasks();
    }
    
}
