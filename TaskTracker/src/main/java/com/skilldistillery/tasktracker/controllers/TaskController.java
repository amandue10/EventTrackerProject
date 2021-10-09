package com.skilldistillery.tasktracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tasktracker.entities.Task;
import com.skilldistillery.tasktracker.services.TaskService;

@RestController
@RequestMapping("api")
public class TaskController {
	@Autowired
	private TaskService taskSvc;
	
	@GetMapping("tasks")
	public List<Task> taskIndex(){
		return taskSvc.getAllTasks();
		
	}
	

}
