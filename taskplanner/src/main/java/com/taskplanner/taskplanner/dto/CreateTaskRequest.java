package com.taskplanner.taskplanner.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class CreateTaskRequest {
    @NotNull
    private Long userId;

    @NotBlank
    private String taskTitle;

    @NotNull
    private Integer taskPoints;

    @NotNull
    private Integer taskPriority;

    @NotNull
    private Integer taskStatus;

    private String taskEpic;

    private LocalDate taskStartDate;

    private LocalDate taskEndDate;
}
