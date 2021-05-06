package com.ibm.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.todo.entity.User;
import com.ibm.todo.pojo.Login;
import com.ibm.todo.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	@Override
	public int addUser(User user) {
		repo.save(user);
		return user.getUserid();
	}

	@Override
	public List<User> getAllUsers() {
		
		return repo.findAll();
	}

	@Override
	public User getUser(int userid) {
		
		return repo.findById(userid).orElseThrow(() -> new IllegalArgumentException("User not found with Id : " + userid));
	}

	@Override
	public User authentication(Login login) {
		// TODO Auto-generated method stub
		return repo.findByEmailAndPasswd(login.getEmail(), login.getPasswd()).orElseThrow(
				() -> new IllegalArgumentException("Invalid Email or Pssword"));
	}

}
