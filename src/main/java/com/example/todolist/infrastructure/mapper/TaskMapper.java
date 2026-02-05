package com.example.todolist.infrastructure.mapper;

import com.example.todolist.domain.model.Task;
import com.example.todolist.infrastructure.entity.TaskEntity;

public class TaskMapper {

    public static TaskEntity toEntity(Task task) {
        if (task == null) return null;

        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDateCompleted(),
                task.getDateCreation()
        );
    }

    public static Task toDomain(TaskEntity taskEntity) {
        if (taskEntity == null) return null;

        return new Task(
                taskEntity.getId(),
                taskEntity.getTitle(),
                taskEntity.getDescription(),
                taskEntity.getStatus(),
                taskEntity.getDateCompleted(),
                taskEntity.getDateCreation()
        );
    }
}
