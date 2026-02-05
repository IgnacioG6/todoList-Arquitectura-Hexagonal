package com.example.todolist.domain.port.in;

import com.example.todolist.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(String title, String description);

}
