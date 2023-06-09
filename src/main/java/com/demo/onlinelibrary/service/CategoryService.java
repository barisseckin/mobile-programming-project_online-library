package com.demo.onlinelibrary.service;

import com.demo.onlinelibrary.dto.CategoryDto;
import com.demo.onlinelibrary.dto.converter.CategoryDtoConverter;
import com.demo.onlinelibrary.exception.GenericException;
import com.demo.onlinelibrary.model.Category;
import com.demo.onlinelibrary.repository.CategoryRepository;
import com.demo.onlinelibrary.request.CreateCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

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

    public void delete(String publicId) {
        Category category = getByPublicId(publicId);
        categoryRepository.deleteById(category.getId());
    }

    public List<CategoryDto> getAll(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return categoryRepository.findAll(pageable)
                .stream()
                .map(categoryDtoConverter::toDto)
                .toList();
    }

    protected Category getByName(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName)
                .orElseThrow(() -> new GenericException("category not found, name: " + categoryName,
                        HttpStatus.NOT_FOUND));
    }

    private Category getByPublicId(String publicId) {
        return categoryRepository.findCategoryByPublicId(publicId)
                .orElseThrow(() -> new GenericException("category not found, publicId: " + publicId,
                        HttpStatus.NOT_FOUND));
    }
}
