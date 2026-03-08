package com.example.CourseManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User>findByEmail(String email);
}
