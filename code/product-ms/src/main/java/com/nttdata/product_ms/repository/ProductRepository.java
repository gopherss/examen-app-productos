package com.nttdata.product_ms.repository;

import com.nttdata.product_ms.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

