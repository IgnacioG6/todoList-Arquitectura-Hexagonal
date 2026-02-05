package com.example.todolist.domain.port.in;

import com.example.todolist.domain.model.Task;

import java.util.List;

public interface GetTaskUseCase {

    List<Task> getAll();
    List<Task> getTaskPendig();
    List<Task> getCompleted();
    Task getById(Long id);

}
