package com.ibm.todo.service;

import java.util.List;

import com.ibm.todo.entity.Todo;
import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;

public interface UserService {
	
	int addUser(User user);
	
	List<User> getAllUsers();
	
	User getUser(int userid);
	
	User authentication(Login login);

}
