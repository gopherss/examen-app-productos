package com.nttdata.stock_ms.repository;

import com.nttdata.stock_ms.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {

}
