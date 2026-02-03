package com.ticker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticker.dto.TaskDto;

public interface TaskRepository extends JpaRepository<TaskDto, Long>{

}
