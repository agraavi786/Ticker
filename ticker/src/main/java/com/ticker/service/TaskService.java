package com.ticker.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.core.task.TaskRejectedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ticker.dto.TaskDto;
import com.ticker.globalExcepion.TaskNotFoundException;
import com.ticker.repository.TaskRepository;

@Service
public class TaskService {
	
	

    private final Map<Long, TaskDto> tasks = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();
    private TaskRepository taskRepository;
    
    
    TaskService(TaskRepository taskRepository){
    	this.taskRepository=taskRepository;
    	
    }

    public Page<TaskDto> getAll(int page, int size) {
    	PageRequest of = PageRequest.of(page, size);
    	return taskRepository.findAll(of);
    }

    public TaskDto getById(Long id) {
    	TaskDto task = tasks.get(id);
        if (task == null) throw new TaskNotFoundException(id);
        return task;
    }

    public TaskDto create(TaskDto task) {
        task.setId(idGenerator.incrementAndGet());
        task.setStatus(TaskDto.Status.PENDING);
        tasks.put(task.getId(), task);
        return task;
    }

    public TaskDto update(Long id, TaskDto updated) {
    	TaskDto existing = getById(id);
        existing.setName(updated.getName());
        existing.setDueDate(updated.getDueDate());
        existing.setPriority(updated.getPriority());
        existing.setStatus(updated.getStatus());
        return existing;
    }

    public void delete(Long id) {
        if (tasks.remove(id) == null) {
            throw new TaskNotFoundException(id);
        }
    }

    public TaskDto complete(Long id) {
    	TaskDto task = getById(id);
        task.setStatus(TaskDto.Status.COMPLETED);
        return task;
    }
}

