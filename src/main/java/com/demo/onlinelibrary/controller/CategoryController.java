package com.demo.onlinelibrary.controller;

import com.demo.onlinelibrary.dto.CategoryDto;
import com.demo.onlinelibrary.request.CreateCategoryRequest;
import com.demo.onlinelibrary.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.demo.onlinelibrary.utils.constant.EndpointPath.CATEGORY_PATH;

@RestController
@RequestMapping(CATEGORY_PATH)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CreateCategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam("publicId") String publicId) {
        categoryService.delete(publicId);
        return ResponseEntity.noContent().build();
    }
}
