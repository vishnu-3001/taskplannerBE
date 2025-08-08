package com.taskplanner.taskplanner.dto;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.taskplanner.taskplanner.model.*;

@Data
@AllArgsConstructor
public class TaskDto {
    private long userId;
    private LocalDateTime createdAt;
    private String taskId;
    private String taskTitle;
    private int taskPoints;
    private Priority taskPriority;
    private Status taskStatus;
    private String taskEpic;
    private LocalDate taskStartDate;
    private LocalDate taskEndDate;
}
