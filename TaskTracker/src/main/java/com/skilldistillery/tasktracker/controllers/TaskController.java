package com.skilldistillery.tasktracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tasktracker.entities.Task;
import com.skilldistillery.tasktracker.services.TaskService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost:4300"})
public class TaskController {
	@Autowired
	private TaskService taskSvc;
	
	@GetMapping("tasks")
	public List<Task> taskIndex(){
		return taskSvc.getAllTasks();
		
	}
	
	@GetMapping("task/{taskId}")
	public Task findTask(@PathVariable Integer taskId) {
		return taskSvc.show(taskId);
	}
	
	@PostMapping("task")
public Task createTask(@RequestBody Task task) {
		return taskSvc.create(task);
	}
	
	@PutMapping("tasks/{taskId}")
	public Task updateTask(@PathVariable Integer taskId, @RequestBody Task task) {
		return taskSvc.update(taskId, task);
	}
	
	@DeleteMapping("task")
	public Boolean deleteTask(@PathVariable Integer taskId) {
		return taskSvc.delete(taskId);
	}

}
