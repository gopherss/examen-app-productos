package com.nttdata.dockerized.postgresql.controller;

import com.nttdata.dockerized.postgresql.model.dto.OrderDto;
import com.nttdata.dockerized.postgresql.model.dto.OrderSaveRequestDto;
import com.nttdata.dockerized.postgresql.model.dto.OrderSaveResponseDto;
import com.nttdata.dockerized.postgresql.model.dto.OrderUpdateRequestDto;
import com.nttdata.dockerized.postgresql.model.entity.Order;
import com.nttdata.dockerized.postgresql.model.entity.User;
import com.nttdata.dockerized.postgresql.service.OrderService;
import com.nttdata.dockerized.postgresql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nttdata.dockerized.postgresql.mapper.OrderMapper.INSTANCE;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return INSTANCE.map(orderService.listAll());
    }

    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        return INSTANCE.map(order);
    }

    @GetMapping("/user/{userId}")
    public List<OrderDto> getOrdersByUser(@PathVariable Long userId) {
        return INSTANCE.map(orderService.findByUser(userId));
    }


    @PostMapping
    public OrderSaveResponseDto saveOrder(@RequestBody OrderSaveRequestDto dto) {
        User user = userService.findById(dto.getUserId());

        Order order = INSTANCE.toEntity(dto);
        order.setUser(user);

        Order saved = orderService.save(order);
        return INSTANCE.toOrderSaveResponseDto(saved);
    }

    @PutMapping("/{id}")
    public OrderDto updateOrder(@PathVariable Long id, @RequestBody OrderUpdateRequestDto orderUpdateRequestDto) {
        Order order = INSTANCE.toEntity(orderUpdateRequestDto);

        Order updated = orderService.updateById(id, order);
        return INSTANCE.map(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }

}
