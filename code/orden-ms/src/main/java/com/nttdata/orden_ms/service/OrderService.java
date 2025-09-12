package com.nttdata.orden_ms.service;


import com.nttdata.orden_ms.model.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> listAll();

    public Order findById(Long id);

    public List<Order> findByUser(Long userId);

    public Order save(Order order);

    public Order updateById(Long id, Order order);

    public void deleteById(Long id);
}
