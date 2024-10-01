package com.shubham.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.entities.Category;
import com.shubham.execption.ResourceNotFoundExecption;
import com.shubham.payloads.CategoryDto;
import com.shubham.repositories.CategoryRepo;
import com.shubham.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
    CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto category) {
	    
		Category cat = this.mapper.map(category,Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		
		return mapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundExecption("category name", "category Id ", categoryId));
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category save = this.categoryRepo.save(cat);
		return this.mapper.map(save, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundExecption("category name", "category Id", categoryId));
		
		return mapper.map(cat, CategoryDto.class);
	}

//	@Override
//	public List<CategoryDto> getAllCategories() {
//		List<Category> all = this.categoryRepo.findAll();
//		List<CategoryDto> collect = all.stream().map(cat->this.mapper.map(all, CategoryDto.class)).collect(Collectors.toList());
//		return collect;
//	}
	
	@Override
	public List<CategoryDto> getAllCategories() {
	    List<Category> all = this.categoryRepo.findAll();
	    List<CategoryDto> collect = all.stream()
	        .map(cat -> this.mapper.map(cat, CategoryDto.class))  // map each individual Category
	        .collect(Collectors.toList());
	    return collect;
	}

	

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundExecption("category name", "category Id", categoryId));
		
		this.categoryRepo.delete(cat);
	}

}
