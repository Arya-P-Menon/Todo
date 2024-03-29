package com.ibm.todo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmailAndPasswd(String email, String passwd);
}
