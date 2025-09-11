package com.nttdata.user_and_category_ms.repository;

import com.nttdata.dockerized.postgresql.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
