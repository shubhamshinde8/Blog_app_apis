package com.shubham.services;

import java.util.List;

import com.shubham.entities.Category;
import com.shubham.payloads.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto category);
	
	CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	
	CategoryDto getCategoryById(Integer categoryId);
	
	List<CategoryDto> getAllCategories();
	
	void deleteCategory(Integer categoryId);
	
}
