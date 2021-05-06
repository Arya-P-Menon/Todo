package com.ibm.todo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;
import com.ibm.todo.service.UserService;

@CrossOrigin()
@RestController
public class UserController {

	@Autowired
	private UserService uservice;
	
	@GetMapping(value="/login", produces="application/json")
	public User validate(@RequestParam String email, @RequestParam String passwd) {
		Login login = new Login();
		login.setEmail(email);
		login.setPasswd(passwd);
		return uservice.authentication(login);
	}
	
	@PostMapping(value="/user" , consumes="application/json" )
	public String addUser(@RequestBody User user) {
		int id =  uservice.addUser(user);	
		return "User added with Id : " + id;
	}
	
	@GetMapping(value="/users" , produces="application/json" )
	public List<User> getAllUsers() {
		return uservice.getAllUsers();	   
	}
	
	@GetMapping(value="/user/{userid}" , produces="application/json" )
	public User getUser(@PathVariable int userid) {
		return uservice.getUser(userid);	   
	}
	
}
