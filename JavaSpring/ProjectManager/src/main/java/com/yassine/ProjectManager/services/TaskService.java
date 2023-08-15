package com.yassine.ProjectManager.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yassine.ProjectManager.models.Task;
import com.yassine.ProjectManager.repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	// Display all Tasks

	public List<Task> allTasks() {
		return taskRepository.findAll();
	}

	// Create a task
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
}