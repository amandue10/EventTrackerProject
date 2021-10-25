import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task';
import { TaskService } from 'src/app/services/task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css'],
})
export class TaskListComponent implements OnInit {
  constructor(private taskService: TaskService) {}
  tasks: Task[] = [];

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.index().subscribe(
      (task) => {
        this.tasks = task;
      },
      (fail) => {
        console.error('PetListComponent.loadTasks(): error loading tasks');
      }
    );
  }
}
