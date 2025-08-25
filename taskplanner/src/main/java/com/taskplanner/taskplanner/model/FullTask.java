package com.taskplanner.taskplanner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name="fullTasks")
@Data
@AllArgsConstructor
@Builder
public class FullTask {
    @NotNull
    @Column(name="user_id",nullable=false)
    private long userId;

    @NotNull
    @Column(name="taskId",nullable = false,unique = true)
    @Id
    private String taskId;

    @NotNull
    @Column(name="taskTitle",nullable = false)
    private String taskTitle;

    @Column(name="taskDesccription")
    private String taskDescription;

    @Column(name="taskStartDate")
    private LocalDate taskStartDate;

    @Column(name="taskEndDate")
    private LocalDate taskEndDate;

    @Column(name="taskPriority")
    private String taskPriority;

    @Column(name="taskStatus")
    private String taskStatus;

    @Column(name="taskPoints")
    private int taskPoints;

    @Column(name="taskEpic")
    private String taskEpic;

    @Column(name="createdAt",nullable = false,updatable=false)
    private LocalDateTime createdAt;

    @Convert(converter=StringConverter.class)
    @Column(name="labels",columnDefinition = "jsonb")
    private List<String>labels;

    @Convert(converter = ChecklistConverter.class)
    @Column(name="checklists",columnDefinition = "jsonb")
    private List<Checklist>checklists;

    @Convert(converter=StringConverter.class)
    @Column(name="urls",columnDefinition = "jsonb")
    private List<String>urls;

}
