package com.nttdata.orden_ms.service;


import com.nttdata.orden_ms.model.entity.OrderDetail;
import com.nttdata.orden_ms.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService  {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail save(OrderDetail detail) {
        return orderDetailRepository.save(detail);
    }
}
