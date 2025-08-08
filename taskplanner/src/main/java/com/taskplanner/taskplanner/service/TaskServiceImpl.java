package com.taskplanner.taskplanner.service;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.stereotype.Service;
import com.taskplanner.taskplanner.repo.*;
import com.taskplanner.taskplanner.model.*;
import com.taskplanner.taskplanner.dto.*;

import org.springframework.context.event.EventListener;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.taskplanner.taskplanner.dto.*;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepo repo;
    public TaskServiceImpl(TaskRepo repo) {
      this.repo = repo;
    }
    @Override
    public TaskDto createTask(CreateTaskRequest req) {
        Task task=Task.builder().userId(req.getUserId())
                .taskTitle(req.getTaskTitle())
                .taskPoints(req.getTaskPoints())
                .taskStatus(Status.fromCode(req.getTaskStatus()))
                .taskPriority(Priority.fromCode(req.getTaskPriority()))
                .taskEpic(req.getTaskEpic())
                .taskStartDate(req.getTaskStartDate())
                .taskEndDate(req.getTaskEndDate())
                .build();
        Task savedTask = repo.save(task);
        return toDto(savedTask);
    }
    @Override
    public List<TaskDto> getTasksForUser(Long userId) {
        return null;
    }
    @Override
    public List<TaskDto> getTasksForUserByState(long userId, int taskStatus) {
        return null;
    }
    @Override
    public List<TaskDto> getAllTasks(){
        List<Task>tasks=repo.findAll();
        List<TaskDto>taskDtos=new ArrayList<>();
        for(Task t:tasks){
            taskDtos.add(toDto(t));
        }
        return taskDtos;
    }
    private TaskDto toDto(Task t) {
        return new TaskDto(
            t.getUserId(),
            t.getCreatedAt(),
            t.getTaskId(),
            t.getTaskTitle(),
            t.getTaskPoints(),
            t.getTaskPriority(),
            t.getTaskStatus(),
            t.getTaskEpic(),
            t.getTaskStartDate(),
            t.getTaskEndDate()
        );
    }
    // @EventListener(ApplicationReadyEvent.class)
    // public void seedSampleTasks() {
    //     if (repo.count() > 0) {
    //         // already have data → skip seeding
    //         return;
    //     }

    //     createTask(CreateTaskRequest.builder()
    //         .userId(101L)
    //         .taskTitle("Sketch UI mockups")
    //         .taskPoints(5)
    //         .taskPriority(Priority.LOW.getCode())
    //         .taskStatus(Status.TODO.getCode())
    //         .taskEpic("EPIC-UI")
    //         .taskStartDate(LocalDate.of(2025,8,2))
    //         .taskEndDate(LocalDate.of(2025,8,3))
    //         .build());

    //         try {
    //             TimeUnit.SECONDS.sleep(2);
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }


    //     createTask(CreateTaskRequest.builder()
    //         .userId(101L)
    //         .taskTitle("Backend service setup")
    //         .taskPoints(8)
    //         .taskPriority(Priority.MEDIUM.getCode())
    //         .taskStatus(Status.IN_PROGRESS.getCode())
    //         .taskEpic("EPIC-API")
    //         .taskStartDate(LocalDate.of(2025,8,3))
    //         .taskEndDate(LocalDate.of(2025,8,6))
    //         .build());
    //         try {
    //             TimeUnit.SECONDS.sleep(2);
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }

    //     createTask(CreateTaskRequest.builder()
    //         .userId(101L)
    //         .taskTitle("Write integration tests")
    //         .taskPoints(3)
    //         .taskPriority(Priority.HIGH.getCode())
    //         .taskStatus(Status.TODO.getCode())
    //         .taskEpic("EPIC-TEST")
    //         .taskStartDate(LocalDate.of(2025,8,4))
    //         .taskEndDate(LocalDate.of(2025,8,5))
    //         .build());
    //         try {
    //             TimeUnit.SECONDS.sleep(2);
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }

    //     createTask(CreateTaskRequest.builder()
    //         .userId(101L)
    //         .taskTitle("Deploy CI/CD pipeline")
    //         .taskPoints(13)
    //         .taskPriority(Priority.MEDIUM.getCode())
    //         .taskStatus(Status.DONE.getCode())
    //         .taskEpic("EPIC-DEVOPS")
    //         .taskStartDate(LocalDate.of(2025,8,5))
    //         .taskEndDate(LocalDate.of(2025,8,7))
    //         .build());
    //         try {
    //             TimeUnit.SECONDS.sleep(2);
    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }

    //     createTask(CreateTaskRequest.builder()
    //         .userId(101L)
    //         .taskTitle("Optimize database indexes")
    //         .taskPoints(7)
    //         .taskPriority(Priority.HIGH.getCode())
    //         .taskStatus(Status.IN_PROGRESS.getCode())
    //         .taskEpic("EPIC-DB")
    //         .taskStartDate(LocalDate.of(2025,8,6))
    //         .taskEndDate(LocalDate.of(2025,8,9))
    //         .build());
    // }
}
