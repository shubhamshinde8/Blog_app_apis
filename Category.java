package com.shubham.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Column(name="category_title",nullable = false,length=100)
	private String categoryTitle;
	
	@Column(name = "description")
	private String categoryDescription;
	
		
	
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
		
	}
	
	
	public String getCategoryTitle() {
		return categoryTitle;
	}
	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}
	

	public String getCategoryDescription() {
	    return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
	    this.categoryDescription = categoryDescription;
	}

	
	
	
}
