package com.example.todolist.infrastructure.controller;

import com.example.todolist.application.service.CompleteTaskService;
import com.example.todolist.application.service.CreateTaskService;
import com.example.todolist.application.service.GetTaskService;
import com.example.todolist.domain.model.Task;
import com.example.todolist.infrastructure.controller.dto.CreateTaskRequest;
import com.example.todolist.infrastructure.controller.dto.TaskResponse;
import com.example.todolist.infrastructure.mapper.TaskDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CompleteTaskService completeTaskService;
    private final CreateTaskService createTaskService;
    private final GetTaskService getTaskService;

    @PostMapping
    public ResponseEntity<TaskResponse> CreateTask(@RequestBody CreateTaskRequest taskRequest) {
        Task task = createTaskService.createTask(taskRequest.title(), taskRequest.description());

        return ResponseEntity.status(HttpStatus.CREATED).body(TaskDTOMapper.toResponseDto(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> tasks = getTaskService.getAll().stream().map(TaskDTOMapper::toResponseDto).toList();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        Task task = getTaskService.getById(id);
        return ResponseEntity.ok(TaskDTOMapper.toResponseDto(task));
    }

    @GetMapping("/complete")
    public ResponseEntity<List<TaskResponse>> getAllCompleteTasks() {
        List<TaskResponse> tasks = getTaskService.getCompleted().stream().map(TaskDTOMapper::toResponseDto).toList();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/pending")
    public ResponseEntity<List<TaskResponse>> getAllCompletePendigTasks() {
        List<TaskResponse> tasks = getTaskService.getTaskPendig().stream().map(TaskDTOMapper::toResponseDto).toList();
        return ResponseEntity.ok(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> completeTask(@PathVariable Long id) {
        Task task = completeTaskService.completeTask(id);
        return ResponseEntity.ok(TaskDTOMapper.toResponseDto(task));
    }

}
