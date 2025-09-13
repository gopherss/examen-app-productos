package com.nttdata.product_ms.controller;


import com.nttdata.product_ms.model.dto.CategoryDto;
import com.nttdata.product_ms.model.dto.CategorySaveRequestDto;
import com.nttdata.product_ms.model.dto.CategorySaveResponseDto;
import com.nttdata.product_ms.model.dto.CategoryUpdateRequestDto;
import com.nttdata.product_ms.model.entity.Category;
import com.nttdata.product_ms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nttdata.product_ms.mapper.CategoryMapper.INSTANCE;


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
