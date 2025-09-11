package com.nttdata.orden_ms.repository;

import com.nttdata.dockerized.postgresql.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
