package com.vinay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinay.model.Task;
import com.vinay.model.User;


public interface TaskRepository extends JpaRepository<Task, Long>{
	List<Task> findByOwnerOrderByDateDesc(User user);

}
