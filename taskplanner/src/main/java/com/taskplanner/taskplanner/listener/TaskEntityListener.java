package com.taskplanner.taskplanner.listener;
import jakarta.persistence.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import com.taskplanner.taskplanner.model.Task;

public class TaskEntityListener {
    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    @PrePersist
    public void onCreate(Task task){
        if (task.getCreatedAt() == null) {
            task.setCreatedAt(LocalDateTime.now());
        }
        String ts = task.getCreatedAt().format(TS_FMT);
        task.setTaskId(task.getUserId() + "_" + ts);

    }
}
