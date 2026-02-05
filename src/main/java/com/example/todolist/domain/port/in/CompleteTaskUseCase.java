package com.example.todolist.domain.port.in;

import com.example.todolist.domain.model.Task;

public interface CompleteTaskUseCase {
    Task completeTask(Long id);
}
