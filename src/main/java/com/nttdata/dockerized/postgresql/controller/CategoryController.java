package com.nttdata.dockerized.postgresql.controller;

import com.nttdata.dockerized.postgresql.model.dto.*;
import com.nttdata.dockerized.postgresql.model.entity.Category;
import com.nttdata.dockerized.postgresql.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nttdata.dockerized.postgresql.mapper.CategoryMapper.INSTANCE;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<CategoryDto>  getAllCategories() {
        return INSTANCE.map(categoryService.listAll());
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return INSTANCE.map(category);
    }
    @PostMapping
    public CategorySaveResponseDto saveCategory(@RequestBody CategorySaveRequestDto dto) {
        Category saved = categoryService.save(INSTANCE.toEntity(dto));
        return INSTANCE.toCategorySaveResponseDto(saved);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable Long id,
                                                      @RequestBody CategoryUpdateRequestDto dto) {
        Category updated = categoryService.updateById(id, INSTANCE.toEntity(dto));

        return INSTANCE.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
