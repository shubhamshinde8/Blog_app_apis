package com.shubham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.payloads.ApiResponse;
import com.shubham.payloads.CategoryDto;
import com.shubham.payloads.UserDto;
import com.shubham.services.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/apis/categories")
public class CategoryController {
	
	@Autowired
	public CategoryService categoryService1;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto category = this.categoryService1.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory( @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
		CategoryDto updateCategory = this.categoryService1.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId")Integer categoryId){
		this.categoryService1.deleteCategory(categoryId);
		return new  ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully..",true),HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategories(){
		
		return ResponseEntity.ok(this.categoryService1.getAllCategories());
		
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getAllCategoriesById(@PathVariable("catId")Integer categoryId){
		return ResponseEntity.ok(this.categoryService1.getCategoryById(categoryId));
	}
	
	
	
	
	

}
