package com.skilldistillery.tasktracker.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Task show(int taskId) {
		Optional<Task> taskOp = taskRepo.findById(taskId);
		if(taskOp.isPresent()) {
			return taskOp.get();
		}
		
		return null;
	}

	@Override
	public Task create(Task task) {
		taskRepo.save(task);

		return task;
	}

	@Override
	public Task update(int taskId, Task task) {
		taskRepo.save(task);
		
		
		return task;
	}

	@Override
	public boolean delete(int taskId) {
		taskRepo.deleteById(taskId);
		
		return !taskRepo.existsById(taskId);
	}

}
