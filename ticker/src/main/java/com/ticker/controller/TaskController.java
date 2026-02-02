package com.ticker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticker.dto.TaskDto;
import com.ticker.dto.TaskRequest;
import com.ticker.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/TaskDtos")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskDto> getAllTaskDtos() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskDto(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public TaskDto create(@Valid @RequestBody TaskRequest request) {
        TaskDto TaskDto = new TaskDto();
        TaskDto.setName(request.getName());
        TaskDto.setDueDate(request.getDueDate());
        TaskDto.setPriority(request.getPriority());
        return service.create(TaskDto);
    }

    @PutMapping("/{id}")
    public TaskDto update(@PathVariable Long id,
                       @Valid @RequestBody TaskRequest request) {
        TaskDto TaskDto = new TaskDto();
        TaskDto.setName(request.getName());
        TaskDto.setDueDate(request.getDueDate());
        TaskDto.setPriority(request.getPriority());
        return service.update(id, TaskDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping("/{id}/complete")
    public TaskDto complete(@PathVariable Long id) {
        return service.complete(id);
    }
}

