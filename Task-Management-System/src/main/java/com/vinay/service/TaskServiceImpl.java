package com.vinay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinay.model.Task;
import com.vinay.model.User;
import com.vinay.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void createTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public void updateTask(Long id, Task updatedTask) {
		Task task = taskRepository.findById(id).get();
		task.setName(updatedTask.getName());
		task.setDescription(updatedTask.getDescription());
		task.setDate(updatedTask.getDate());
		taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findByOwnerOrderByDateDesc(User user) {
		return taskRepository.findByOwnerOrderByDateDesc(user);
	}

	@Override
	public void setTaskCompleted(Long id) {
		Task task = taskRepository.findById(id).get();
		task.setCompleted(true);
		taskRepository.save(task);
	}

	@Override
	public void setTaskNotCompleted(Long id) {
		Task task = taskRepository.findById(id).get();
		task.setCompleted(false);
		taskRepository.save(task);
	}

	@Override
	public List<Task> findFreeTasks() {
		return taskRepository.findAll().stream().filter(task -> task.getOwner() == null && !task.isCompleted())
				.collect(Collectors.toList());

	}

	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public void assignTaskToUser(Task task, User user) {
		task.setOwner(user);
		taskRepository.save(task);
	}

	@Override
	public void unassignTask(Task task) {
		task.setOwner(null);
		taskRepository.save(task);
	}

}
