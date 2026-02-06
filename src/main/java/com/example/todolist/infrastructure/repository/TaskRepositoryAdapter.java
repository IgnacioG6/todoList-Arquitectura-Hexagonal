package com.example.todolist.infrastructure.repository;

import com.example.todolist.domain.model.Task;
import com.example.todolist.domain.port.out.TaskRepositoryPort;
import com.example.todolist.infrastructure.entity.TaskEntity;
import com.example.todolist.infrastructure.mapper.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository taskRepository;
    public TaskRepositoryAdapter(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskMapper.toEntity(task);

        TaskEntity savedEntity = taskRepository.save(taskEntity);

        return TaskMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll().stream().map(TaskMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
