package com.taskplanner.taskplanner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="tasklets")
@Data @AllArgsConstructor @Builder
@EntityListeners(com.taskplanner.taskplanner.listener.TaskEntityListener.class)
public class Task {
    @NotNull
    @Column(name="user_id",nullable=false)
    private long userId;

    @NotNull
    @Column(name="createdAt",nullable=false,updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;

    @NotNull
    @Column(name="taskId",nullable=false,unique=true)
    private String taskId;

    @NotNull
    @Column(name="taskTitle",nullable = false)
    private String taskTitle;

    @NotNull
    @Column(name="taskPoints",nullable = false)
    private int taskPoints;

    @Convert(converter = PriorityConverter.class)
    @Column(name="taskPriority")
    private int taskPriority;

    @Convert(converter = StatusConverter.class)
    @NotNull
    @Column(name="taskStatus",nullable = false)
    private int taskStatus;

    @Column(name="taskEpic")
    private String taskEpic;

    @Column(name="taskStartDate")
    private LocalDate taskStartDate;

    @Column(name="taskEndDate")
    private LocalDate taskEndDate;
    public Task(){}
}
