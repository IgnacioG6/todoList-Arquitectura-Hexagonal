package com.example.todolist.application.service;

import com.example.todolist.domain.model.Task;
import com.example.todolist.domain.port.in.CreateTaskUseCase;
import com.example.todolist.domain.port.out.TaskRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRespository;

    public CreateTaskService(TaskRepositoryPort taskRespository) {
        this.taskRespository = taskRespository;
    }
    
    @Override
    public Task createTask(String title, String description) {
        Task task = new Task(title, description);
        taskRespository.save(task);
        return task;
    }
}
