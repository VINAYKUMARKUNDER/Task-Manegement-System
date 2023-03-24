package com.vinay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
