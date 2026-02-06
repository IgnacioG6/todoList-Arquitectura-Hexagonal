package com.example.todolist.infrastructure.controller.dto;

import java.time.LocalDateTime;

public record TaskResponse(
        String title,
        String description,
        String status,
        LocalDateTime dateCreation,
        LocalDateTime dateCompleted
) {
}
