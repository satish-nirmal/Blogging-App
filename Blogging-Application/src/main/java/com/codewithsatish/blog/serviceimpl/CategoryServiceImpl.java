package com.codewithsatish.blog.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsatish.blog.enitity.Category;
import com.codewithsatish.blog.payload.CategoryDto;
import com.codewithsatish.blog.repository.CategoryRepository;
import com.codewithsatish.blog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

		Category cat = modelMapper.map(categoryDto, Category.class);

		Category addedCat = categoryRepository.save(cat);

		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

		Category cat = categoryRepository.findByCategoryId(categoryId);

		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());

		Category saveCategory = categoryRepository.save(cat);

		return this.modelMapper.map(saveCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {

		this.categoryRepository.deleteById(categoryId);

	}

	@Override
	public CategoryDto findCategoryById(Integer categoryId) {

		List<Category> allCategory = categoryRepository.findAll();

		Optional<Category> findCategory = allCategory.stream().filter(item -> item.getCategoryId() == categoryId)
				.findFirst();

		if (findCategory.isPresent()) {

			Category category = findCategory.get();

			CategoryDto cat = this.modelMapper.map(category, CategoryDto.class);
			return cat;
		} else {
			return null;
		}
	}

	@Override
	public CategoryDto findAllCategory() {

		List<Category> findAllCategory = categoryRepository.findAll();

		CategoryDto cat = this.modelMapper.map(findAllCategory, CategoryDto.class);

		return cat;
	}

}
