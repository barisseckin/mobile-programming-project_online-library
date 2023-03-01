package com.demo.onlinelibrary.utils.converter;

import com.demo.onlinelibrary.dto.CategoryDto;
import com.demo.onlinelibrary.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public CategoryDto toDto(Category from) {
        return new CategoryDto(
                from.getPublicId(),
                from.getName(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }
}
