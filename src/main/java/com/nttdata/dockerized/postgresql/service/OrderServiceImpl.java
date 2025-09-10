package com.nttdata.dockerized.postgresql.service;

import com.nttdata.dockerized.postgresql.exception.BadRequestException;
import com.nttdata.dockerized.postgresql.exception.NotFoundException;
import com.nttdata.dockerized.postgresql.model.entity.Order;
import com.nttdata.dockerized.postgresql.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido no encontrado","404"));
    }

    @Override
    public List<Order> findByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public Order save(Order order) {
        if (order.getStatus() == null || order.getStatus().isBlank()){
            throw new BadRequestException("El Estado es obligatorio");
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateById(Long id, Order order) {
        return orderRepository.findById(id)
                .map(orderExisting ->{
                    orderExisting.setStatus(order.getStatus());
                    return orderRepository.save(orderExisting);
                }).orElseThrow( () -> new NotFoundException("Pedido no encontrado par actualizar","404"));
    }

    @Override
    public void deleteById(Long id) {
        if (!orderRepository.existsById(id)){
            throw new NotFoundException("Orden no encontrada para eliminar","404");
        }
        orderRepository.deleteById(id);
    }
}
