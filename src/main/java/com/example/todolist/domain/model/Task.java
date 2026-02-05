package com.example.todolist.domain.model;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String title;
    private String description;
    private EstadoTarea status;
    private LocalDateTime dateCreation;
    private LocalDateTime dateCompleted;

    public Task(String title, String description) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("El título no puede estar vacío");
        }

        this.title = title;
        this.description = description;
        this.status = EstadoTarea.PENDING;
        this.dateCompleted = null;
        this.dateCreation = LocalDateTime.now();
    }


    public Task(Long id, String title, String description, EstadoTarea status,
                LocalDateTime dateCreation, LocalDateTime dateCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dateCreation = dateCreation;
        this.dateCompleted = dateCompleted;
    }


    public void complete() {
        if (this.status == EstadoTarea.COMPLETED) {
            throw new IllegalStateException("La tarea ya está completada");
        }
        this.status = EstadoTarea.COMPLETED;
        this.dateCompleted = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitule(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EstadoTarea getStatus() {
        return status;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDateTime dateCompleted) {
        this.dateCompleted = dateCompleted;
    }
}
