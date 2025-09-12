package com.nttdata.orden_ms.repository;


import com.nttdata.orden_ms.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
