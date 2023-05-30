package com.demo.onlinelibrary.service;

import com.demo.onlinelibrary.dto.CategoryDto;
import com.demo.onlinelibrary.dto.converter.CategoryDtoConverter;
import com.demo.onlinelibrary.model.Category;
import com.demo.onlinelibrary.repository.CategoryRepository;
import com.demo.onlinelibrary.request.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public CategoryDto save(CreateCategoryRequest request) {
        Category saved = new Category(request.getName());
        categoryRepository.save(saved);
        return categoryDtoConverter.toDto(saved);
    }
}
