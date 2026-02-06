package com.example.todolist.application.service;

import com.example.todolist.domain.exception.TaskNotFoundException;
import com.example.todolist.domain.model.Task;
import com.example.todolist.domain.port.in.CompleteTaskUseCase;
import com.example.todolist.domain.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CompleteTaskService implements CompleteTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    public CompleteTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepository = taskRepositoryPort;
    }

    @Override
    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.complete();
        taskRepository.save(task);
        return task;

    }
}
