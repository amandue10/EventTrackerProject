import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Task } from 'src/app/models/task';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/tasks';

  constructor(private http: HttpClient) {}

  index(): Observable<Task[]> {
    return this.http.get<Task[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.index(): Error retrieving todo list');
      })
    );
  }
}
