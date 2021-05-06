package com.ibm.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.todo.entity.Todo;
import com.ibm.todo.entity.User;
import com.ibm.todo.service.TodoService;

@CrossOrigin()
@RestController
public class TodoController {
	
	@Autowired
	private TodoService tservice;
	
	@PostMapping(value="/todo/{userid}" , consumes="application/json" )
	public String addTodo(@RequestBody Todo todo, @PathVariable int userid) {
		int id =  tservice.addTodo(todo, userid);	
		return "Todo added with Id : " + id;
	}
	
	@GetMapping(value="/todo/{id}" , produces="application/json" )
	public Todo getTodo(@PathVariable int id) {
		return tservice.getTodo(id);	   
	}
	
	@GetMapping(value="/todo/user/{userid}" , produces="application/json" )
	public List<Todo> getUserTodo(@PathVariable int userid) {
		return tservice.todoByUser(userid);	   
	}
	
	
}
