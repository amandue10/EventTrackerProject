package com.skilldistillery.tasktracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tasktracker.entities.Task;
import com.skilldistillery.tasktracker.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	

	@Override
	public List<Task> getAllTasks() {
		return taskRepo.findAll();
	}

}
