package com.yuvaraj.challenge.todo_list_api.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

@Data
public class TodoDTO {

    @NotBlank(message = "Task id can't be empty")
    @NotNull(message = "Task id can't be null")
    @Pattern(regexp = "[0-9]*", message = "Task id contains only numbers")
    private String id;

    @NotBlank(message = "Task title can't be blank")
    private String title;

    private String description;
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
