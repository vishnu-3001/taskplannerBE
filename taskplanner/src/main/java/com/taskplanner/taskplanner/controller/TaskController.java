package com.taskplanner.taskplanner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.taskplanner.taskplanner.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.taskplanner.taskplanner.dto.*;
import java.util.*;


@RestController
@RequestMapping("/api/tasks")
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
