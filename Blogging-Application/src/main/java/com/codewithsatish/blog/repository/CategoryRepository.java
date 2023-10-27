package com.codewithsatish.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codewithsatish.blog.enitity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	public Category findByCategoryId(Integer categoryId);
}
