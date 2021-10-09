package com.skilldistillery.tasktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tasktracker.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {








}
