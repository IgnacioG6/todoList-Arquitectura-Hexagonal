package com.example.todolist.infrastructure.mapper;

import com.example.todolist.domain.model.Task;
import com.example.todolist.infrastructure.controller.dto.TaskResponse;

public class TaskDTOMapper {

    public static TaskResponse toResponseDto(Task task) {
        if (task == null) return null;

        return new TaskResponse(
                task.getTitle(),
                task.getDescription(),
                task.getStatus().toString(),
                task.getDateCreation(),
                task.getDateCompleted()
        );
    }

}
