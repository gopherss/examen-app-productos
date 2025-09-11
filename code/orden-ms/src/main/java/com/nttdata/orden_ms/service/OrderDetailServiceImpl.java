package com.nttdata.orden_ms.service;

import com.nttdata.dockerized.postgresql.model.entity.OrderDetail;
import com.nttdata.dockerized.postgresql.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail save(OrderDetail detail) {
        return orderDetailRepository.save(detail);
    }
}
