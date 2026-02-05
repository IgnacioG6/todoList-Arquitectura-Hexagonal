package com.example.todolist.application.service;

import com.example.todolist.domain.exception.TaskNotFoundException;
import com.example.todolist.domain.model.EstadoTarea;
import com.example.todolist.domain.model.Task;
import com.example.todolist.domain.port.in.GetTaskUseCase;
import com.example.todolist.domain.port.out.TaskRepositoryPort;

import java.util.List;

public class GetTaskService implements GetTaskUseCase {


    private final TaskRepositoryPort taskRepository;

    public GetTaskService(TaskRepositoryPort taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTaskPendig() {
        return taskRepository.findAll().stream()
                .filter(task -> task.getStatus().equals(EstadoTarea.PENDING))
                .toList();
    }

    @Override
    public List<Task> getCompleted() {
        return taskRepository.findAll().stream()
                .filter(task -> task.getStatus().equals(EstadoTarea.COMPLETED))
                .toList();
    }

    @Override
    public Task getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return task;
    }
}