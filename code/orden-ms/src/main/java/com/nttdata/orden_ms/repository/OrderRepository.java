package com.nttdata.orden_ms.repository;

import com.nttdata.orden_ms.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long clientId);
}
