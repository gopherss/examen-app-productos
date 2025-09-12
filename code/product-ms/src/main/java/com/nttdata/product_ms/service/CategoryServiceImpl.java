package com.nttdata.product_ms.service;


import com.nttdata.product_ms.exception.BadRequestException;
import com.nttdata.product_ms.exception.NotFoundException;
import com.nttdata.product_ms.model.entity.Category;
import com.nttdata.product_ms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria no encontrada","404"));
    }

    @Override
    public Category save(Category category) {

        if (category.getName() == null || category.getName().isBlank()){
            throw new BadRequestException("La categoria es obligatoria");
        }

        return categoryRepository.save(category);
    }

    @Override
    public Category updateById(Long id, Category category) {
        return categoryRepository.findById(id)
                .map(categoryExisting -> {
                    categoryExisting.setName(category.getName());
                    return categoryRepository.save(categoryExisting);
                }).orElseThrow(() -> new NotFoundException("Categoria no encontrada para acttualizar", "404"));
    }

    @Override
    public void deleteById(Long id) {
        if (categoryRepository.existsById(id)){
            throw new NotFoundException("Categoria no encontrada para eliminar","404");
        }
        categoryRepository.deleteById(id);
    }
}
