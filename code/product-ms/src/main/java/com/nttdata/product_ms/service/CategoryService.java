package com.nttdata.product_ms.service;


import com.nttdata.product_ms.model.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listAll();

    Category findById(Long id);

    Category save(Category category);

    Category updateById(Long id, Category category);

    void deleteById(Long id);

}
