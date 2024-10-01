package com.shubham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
