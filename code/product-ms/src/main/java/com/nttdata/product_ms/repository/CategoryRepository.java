package com.nttdata.product_ms.repository;

import com.nttdata.product_ms.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
