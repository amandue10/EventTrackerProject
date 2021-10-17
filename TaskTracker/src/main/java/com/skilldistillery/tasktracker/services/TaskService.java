package com.skilldistillery.tasktracker.services;

import java.util.List;

import com.skilldistillery.tasktracker.entities.Task;

public interface TaskService {

	List<Task> getAllTasks();
	Task show(int taskId);
	Task create(Task task);
	Task update(int taskId, Task task);
	boolean delete(int taskId);
	
	
	
}
