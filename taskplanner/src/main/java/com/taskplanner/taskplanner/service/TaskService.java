package com.taskplanner.taskplanner.service;
import com.taskplanner.taskplanner.dto.*;
import java.util.*;

public interface TaskService {
    TaskDto createTask(CreateTaskRequest req);
    List<TaskDto> getTasksForUser(Long userId);
    List<TaskDto> getTasksForUserByState(long userId, int taskStatus);
    Map<String,List<TaskDto>> getAllTasks();
}
