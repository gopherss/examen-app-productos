package com.nttdata.orden_ms.controller;

import com.nttdata.orden_ms.model.dto.OrderDetailDto;
import com.nttdata.orden_ms.model.entity.Order;
import com.nttdata.orden_ms.service.OrderDetailService;
import com.nttdata.orden_ms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping
    public OrderDetailDto saveOrderDetail(@RequestBody OrderDetailRequestDto orderDetailRequestDto) {
        Order order = orderService.findById(orderDetailRequestDto.getOrderId());
        Product product = productService.findById(orderDetailRequestDto.getProductId());

        OrderDetail detail = INSTANCE.toEntity(orderDetailRequestDto);
        detail.setOrder(order);
        detail.setProduct(product);

        OrderDetail saved = orderDetailService.save(detail);
        return INSTANCE.map(saved);
    }
}
