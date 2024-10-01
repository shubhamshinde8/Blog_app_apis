package com.shubham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
