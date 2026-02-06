package com.example.todolist.infrastructure.controller.dto;

public record CreateTaskRequest(
        String title,
        String description

) {
}
