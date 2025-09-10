package com.nttdata.dockerized.postgresql.service;

import com.nttdata.dockerized.postgresql.model.entity.OrderDetail;

public interface OrderDetailService {
    public OrderDetail save(OrderDetail detail);
}
