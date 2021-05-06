import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TodoModel } from 'src/todo.model';
import { UserModel } from '../user.model';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUri : string = "http://localhost:8780";
  
  constructor(private http : HttpClient) { }

  createTodo(todo : TodoModel) {
    let user: UserModel;
    user=JSON.parse(localStorage.getItem("user"));
    console.log(todo.assignDate+"   "+todo.finishDate)
    this.http.post(this.baseUri+"/todo/"+user.userid, todo).subscribe(data => data = todo);
  }

  todoById(id : number) :Observable<TodoModel> {
    return this.http.get<TodoModel>(this.baseUri+"/todo/" + id);
  }

   async todoByUser() {
   
    let user: UserModel;
    user=JSON.parse(localStorage.getItem("user"));
    return  await this.http.get<TodoModel[]>(this.baseUri+"/todo/user/" + user.userid).toPromise();
    
  }
}