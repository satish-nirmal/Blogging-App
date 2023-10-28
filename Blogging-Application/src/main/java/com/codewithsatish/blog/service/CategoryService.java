package com.codewithsatish.blog.service;

import org.springframework.stereotype.Service;

import com.codewithsatish.blog.payload.CategoryDto;

@Service
public interface CategoryService {

//	#Create 

	public CategoryDto createCategory(CategoryDto categoryDto);

//	Update

	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

//	delete

	public void deleteCategory(Integer categoryId);

//	findById

	public CategoryDto findCategoryById(Integer categoryId);

//	findAll

	public CategoryDto findAllCategory();
}
